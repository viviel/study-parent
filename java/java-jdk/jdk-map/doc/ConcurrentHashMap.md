# 关键点

- CAS操作
- synchronized锁

# 属性

`sizeCtl` 用于标识map是否初始化或扩容（小于0）

# 方法

## initTable

### 流程

- 循环判断table是否为空
- sizeCtl若为负数，则让出cpu时间片
- 使用CAS操作抢占sizeCtl，如果失败，则继续循环
- 成功将sizeCtl设置为-1后，需要再对table是否为空进行判断。防止上面抢占失败的线程重复进行初始化
- 符合条件后，进行扩容操作

```java
private final Node<K,V>[] initTable() {
    Node<K,V>[] tab; int sc;
    while ((tab = table) == null || tab.length == 0) {
        if ((sc = sizeCtl) < 0)
            Thread.yield(); // lost initialization race; just spin
        else if (U.compareAndSwapInt(this, SIZECTL, sc, -1)) {
            try {
                if ((tab = table) == null || tab.length == 0) {
                    int n = (sc > 0) ? sc : DEFAULT_CAPACITY;
                    @SuppressWarnings("unchecked")
                    Node<K,V>[] nt = (Node<K,V>[])new Node<?,?>[n];
                    table = tab = nt;
                    sc = n - (n >>> 2);
                }
            } finally {
                sizeCtl = sc;
            }
            break;
        }
    }
    return tab;
}
```



## get

### 流程

- 获取哈希值
- 计算索引并查看该位置是否为空
- 如果哈希值和key相等，则返回对应的value
- 否则查看哈希值是否小于0
- 若小于0则说明该节点是红黑树
- 若不小于0，则顺着链表依次查找

```java
public V get(Object key) {
    Node<K,V>[] tab; Node<K,V> e, p; int n, eh; K ek;
    int h = spread(key.hashCode());
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (e = tabAt(tab, (n - 1) & h)) != null) {
        if ((eh = e.hash) == h) {
            if ((ek = e.key) == key || (ek != null && key.equals(ek)))
                return e.val;
        }
        else if (eh < 0)
            return (p = e.find(h, key)) != null ? p.val : null;
        while ((e = e.next) != null) {
            if (e.hash == h &&
                ((ek = e.key) == key || (ek != null && key.equals(ek))))
                return e.val;
        }
    }
    return null;
}
```



## put

### 说明

`binCount` 链表长度

### 流程

- 获取hash值
- 如果table为空，则进行初始化
- 计算key的index
- 如果index处节点为空，则使用CAS操作赋值
- 如果正在扩容，则当前线程加入扩容任务中
- 准备执行赋值或更新操作
- 对当前index节点加锁
- 如果index节点为链表（hash>=0），则遍历查找符合条件的位置并赋值
- 如果节点为红黑树，则通过putTreeVal方法进行赋值操作
- 赋值结束后，如果链表应该转换为红黑树，则调用treeifyBin方法
- 如果是更新操作，则return
- 调用addCount增加数量/扩容

```java
/**
 * 索引节点：位于table上的节点
 */
final V putVal(K key, V value, boolean onlyIfAbsent) {
    if (key == null || value == null) throw new NullPointerException();
    //获取hash值
    int hash = spread(key.hashCode());
    //只记录当前table索引节点链表长度，不记录红黑树节点数
    int binCount = 0;
    for (Node<K,V>[] tab = table;;) {
        //f：索引节点引用
        //n：table length
        //i：索引节点的下标
        //fh：索引节点的hash值
        Node<K,V> f; int n, i, fh;
        //table是否为空
        if (tab == null || (n = tab.length) == 0)
            //进行初始化
            tab = initTable();
        //table索引节点是否为空
        else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
            //CAS插入，成功则bread循环，否则自旋直到成功插入
            if (casTabAt(tab, i, null,
                         new Node<K,V>(hash, key, value, null)))
                break;                   // no lock when adding to empty bin
        }
        //map是否正在扩容
        else if ((fh = f.hash) == MOVED)
            //当前线程加入扩容任务中
            tab = helpTransfer(tab, f);
        //执行插入操作。索引节点可能为链表，也可能为红黑树
        else {
            V oldVal = null;
            //对索引节点加锁
            synchronized (f) {
                //此处判断的原因存疑
                if (tabAt(tab, i) == f) {
                    //通过索引节点hash值判断是否为链表
                    if (fh >= 0) {
                        binCount = 1;
                        for (Node<K,V> e = f;; ++binCount) {
                            //e：遍历链表时的临时引用
                            K ek;
                            //是否为更新操作
                            if (e.hash == hash &&
                                ((ek = e.key) == key ||
                                 (ek != null && key.equals(ek)))) {
                                oldVal = e.val;
                                if (!onlyIfAbsent)
                                    e.val = value;
                                break;
                            }
                            Node<K,V> pred = e;
                            //将value插入到链表尾部
                            if ((e = e.next) == null) {
                                pred.next = new Node<K,V>(hash, key,
                                                          value, null);
                                break;
                            }
                        }
                    }
                    //是否为红黑树
                    else if (f instanceof TreeBin) {
                        Node<K,V> p;
                        binCount = 2;
                        if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                              value)) != null) {
                            oldVal = p.val;
                            if (!onlyIfAbsent)
                                p.val = value;
                        }
                    }
                }
            }
            if (binCount != 0) {
                //链表是否应该转换为红黑树
                if (binCount >= TREEIFY_THRESHOLD)
                    treeifyBin(tab, i);
                //判断是更新还是插入操作
                if (oldVal != null)
                    return oldVal;
                break;
            }
        }
    }
    //增加map数量/执行扩容操作
    addCount(1L, binCount);
    return null;
}
```

## addCount

### 流程

```java
private final void addCount(long x, int check) {
    CounterCell[] as; long b, s;
    if ((as = counterCells) != null ||
        !U.compareAndSwapLong(this, BASECOUNT, b = baseCount, s = b + x)) {
        CounterCell a; long v; int m;
        boolean uncontended = true;
        if (as == null || (m = as.length - 1) < 0 ||
            (a = as[ThreadLocalRandom.getProbe() & m]) == null ||
            !(uncontended =
              U.compareAndSwapLong(a, CELLVALUE, v = a.value, v + x))) {
            fullAddCount(x, uncontended);
            return;
        }
        if (check <= 1)
            return;
        s = sumCount();
    }
    if (check >= 0) {
        Node<K,V>[] tab, nt; int n, sc;
        while (s >= (long)(sc = sizeCtl) && (tab = table) != null &&
               (n = tab.length) < MAXIMUM_CAPACITY) {
            int rs = resizeStamp(n);
            if (sc < 0) {
                if ((sc >>> RESIZE_STAMP_SHIFT) != rs || sc == rs + 1 ||
                    sc == rs + MAX_RESIZERS || (nt = nextTable) == null ||
                    transferIndex <= 0)
                    break;
                if (U.compareAndSwapInt(this, SIZECTL, sc, sc + 1))
                    transfer(tab, nt);
            }
            else if (U.compareAndSwapInt(this, SIZECTL, sc,
                                         (rs << RESIZE_STAMP_SHIFT) + 2))
                transfer(tab, null);
            s = sumCount();
        }
    }
}
```

