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

## get

### 流程

- 获取哈希值
- 计算索引并查看该位置是否为空
- 如果哈希值和key相等，则返回对应的value
- 否则查看哈希值是否小于0
- 若小于0则说明该节点是红黑树
- 若不小于0，则顺着链表依次查找

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
final V putVal(K key, V value, boolean onlyIfAbsent) {
    if (key == null || value == null) throw new NullPointerException();
    //获取hash值
    int hash = spread(key.hashCode());
    //记录当前table节点链表长度
    int binCount = 0;
    for (Node<K,V>[] tab = table;;) {
        Node<K,V> f; int n, i, fh;
        if (tab == null || (n = tab.length) == 0)
            //如果table为空，进行初始化
            tab = initTable();
        else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
            if (casTabAt(tab, i, null,
                         new Node<K,V>(hash, key, value, null)))
                break;                   // no lock when adding to empty bin
        }
        else if ((fh = f.hash) == MOVED)
            tab = helpTransfer(tab, f);
        else {
            V oldVal = null;
            synchronized (f) {
                if (tabAt(tab, i) == f) {
                    if (fh >= 0) {
                        binCount = 1;
                        for (Node<K,V> e = f;; ++binCount) {
                            K ek;
                            if (e.hash == hash &&
                                ((ek = e.key) == key ||
                                 (ek != null && key.equals(ek)))) {
                                oldVal = e.val;
                                if (!onlyIfAbsent)
                                    e.val = value;
                                break;
                            }
                            Node<K,V> pred = e;
                            if ((e = e.next) == null) {
                                pred.next = new Node<K,V>(hash, key,
                                                          value, null);
                                break;
                            }
                        }
                    }
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
                if (binCount >= TREEIFY_THRESHOLD)
                    treeifyBin(tab, i);
                if (oldVal != null)
                    return oldVal;
                break;
            }
        }
    }
    addCount(1L, binCount);
    return null;
}
```

