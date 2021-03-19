# 关键点

- CAS操作
- synchronized锁
- 通过baseCount和CounterCells数组节点两个属性来记录map元素数量

# 属性

注意：位运算均使用补码计算

- `sizeCtl` 用于标识

  初始化：-1

  扩容：负数。低16位，参与扩容线程数 = 低16位的值 - 1。高16位，可扩容次数 = 高16位无符号值 - 1

  阈值：正数。table.length * 0.75

- `baseCount` 正常统计map元素数量时使用这个属性，如果多个线程竞争，则会启用CounterCell数组来分散线程竞争，提高效率。

- `CounterCells` 计数器单元数组。节点和线程关联，可减少记录元素增加时的冲突

- `transferIndex` 扩容时用于界定未分配给线程的节点和已分配给线程的节点

  未分配给线程的节点：table[0] 至 table[transferIndex]

  已分配给线程的节点：table[transferIndex] 至 table[table.length - 1]

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

### 作用

- 存储元素。如果table节点为空，则CAS插入，否则对该节点加锁，插入节点上的链表或红黑树
- 增加元素数量
- table扩容

### 流程

```java
final V putVal(K key, V value, boolean onlyIfAbsent) {
    if (key == null || value == null) throw new NullPointerException();
    //获取hash值
    int hash = spread(key.hashCode());
    //只记录当前table节点链表长度，不记录红黑树节点数
    int binCount = 0;
    for (Node<K,V>[] tab = table;;) {
        //f：table节点引用
        //n：table length
        //i：table节点的下标
        //fh：table节点的hash值
        Node<K,V> f; int n, i, fh;
        //table是否为空
        if (tab == null || (n = tab.length) == 0)
            //进行初始化
            tab = initTable();
        //table节点是否为空
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
        //执行插入操作。table节点可能为链表，也可能为红黑树
        else {
            V oldVal = null;
            //对table节点加锁
            synchronized (f) {
                //此处判断的原因存疑
                if (tabAt(tab, i) == f) {
                    //通过table节点hash值判断是否为链表
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

### 作用

- 增加map元素数量。根据情况增加counterCells或baseCount的值
- table扩容。检查是否需要扩容，如果需要扩容，则调用扩容方法，如果正在扩容，则帮助扩容

### 注意点

- 第一次调用扩容方法前，sizeCtl 的低 16 位是加 2 的，不是加一。所以 sc == rs + 1 的判断是表示是否完成任务了。因为完成扩容后，sizeCtl == rs + 1

- 扩容线程最大数量是 65535，是由于低 16 位的位数限制

- 这里也是可以帮助扩容的，类似 helpTransfer 方法

### 流程

```java
private final void addCount(long x, int check) {
    //as：计数器单元数组，如果baseCount CAS增加失败，则会增加as某个节点的数量
    //b：baseCount
    //s：baseCount + x
    CounterCell[] as; long b, s;
    //增加元素数量
    //as不等于空
    //baseCount CAS赋值失败
    if ((as = counterCells) != null ||
        !U.compareAndSwapLong(this, BASECOUNT, b = baseCount, s = b + x)) {
        //a：计数器单元节点
        //v：a节点值
        //m：a节点下标
        CounterCell a; long v; int m;
        boolean uncontended = true;
        //as为空
        //as length等于0
        //计数器单元节点a为空
        //计数器单元节点a CAS赋值失败
        if (as == null || (m = as.length - 1) < 0 ||
            (a = as[ThreadLocalRandom.getProbe() & m]) == null ||
            !(uncontended =
              U.compareAndSwapLong(a, CELLVALUE, v = a.value, v + x))) {
            //自旋增加元素数量/计数器单元扩容（*2）
            fullAddCount(x, uncontended);
            return;
        }
        if (check <= 1)
            return;
        s = sumCount();
    }
    //检查是否需要扩容
    if (check >= 0) {
        //tab：table
        //nt：nextTable
        //n：tab.length
        //sc：sizeCtl
        Node<K,V>[] tab, nt; int n, sc;
        //增加数量后大于等于阈值
        while (s >= (long)(sc = sizeCtl) && (tab = table) != null &&
               (n = tab.length) < MAXIMUM_CAPACITY) {
            int rs = resizeStamp(n);
            //是否正在初始化或扩容
            if (sc < 0) {
                //验证是否需要帮助执行扩容操作
                //此处有bug，jdk12已修复
                //
                //
                //(sc >>> RESIZE_STAMP_SHIFT) != rs
                //
                //已经没有线程在扩容
                //sc == rs + 1 改为：
                //sc == (rs << RESIZE_STAMP_SHIFT) + 1
                //
                //参与扩容的线程数量已到达最大值
                //sc == rs + MAX_RESIZERS 改为：
                //sc == (rs << RESIZE_STAMP_SHIFT) + MAX_RESIZERS
                if ((sc >>> RESIZE_STAMP_SHIFT) != rs || sc == rs + 1 ||
                    sc == rs + MAX_RESIZERS || (nt = nextTable) == null ||
                    transferIndex <= 0)
                    break;
                //帮助扩容，参与扩容的线程数+1
                //二进制表示：0b10000000_00011011_00000000_00000011
                //低16位：00000000_00000011
                if (U.compareAndSwapInt(this, SIZECTL, sc, sc + 1))
                    transfer(tab, nt);
            }
            //进行扩容，sizeCtl高16位保存rs信息，低16位保存参与扩容的线程数量信息
            //二进制表示：0b10000000_00011011_00000000_00000010
            //低16位：00000000_00000010
            else if (U.compareAndSwapInt(this, SIZECTL, sc,
                                         (rs << RESIZE_STAMP_SHIFT) + 2))
                transfer(tab, null);
            s = sumCount();
        }
    }
}
```

## fullAddCount

### 作用

- 自旋增加map元素数量值
- 初始化/扩容counterCells

### 流程

```java
private final void fullAddCount(long x, boolean wasUncontended) {
    int h;
    if ((h = ThreadLocalRandom.getProbe()) == 0) {
        ThreadLocalRandom.localInit();      // force initialization
        h = ThreadLocalRandom.getProbe();
        wasUncontended = true;
    }
    boolean collide = false;                // True if last slot nonempty
    for (;;) {
        CounterCell[] as; CounterCell a; int n; long v;
        //counterCells可用
        if ((as = counterCells) != null && (n = as.length) > 0) {
            //当前节点为空
            if ((a = as[(n - 1) & h]) == null) {
                //counterCells没有被使用
                if (cellsBusy == 0) {            // Try to attach new Cell
                    CounterCell r = new CounterCell(x); // Optimistic create
                    //加锁
                    if (cellsBusy == 0 &&
                        U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                        boolean created = false;
                        try {               // Recheck under lock
                            CounterCell[] rs; int m, j;
                            //再次当前检查节点是否为空
                            if ((rs = counterCells) != null &&
                                (m = rs.length) > 0 &&
                                rs[j = (m - 1) & h] == null) {
                                rs[j] = r;
                                created = true;
                            }
                        } finally {
                            cellsBusy = 0;
                        }
                        if (created)
                            break;
                        continue;           // Slot is now non-empty
                    }
                }
                collide = false;
            }
            else if (!wasUncontended)       // CAS already known to fail
                wasUncontended = true;      // Continue after rehash
            //直接增加已存在节点的值
            else if (U.compareAndSwapLong(a, CELLVALUE, v = a.value, v + x))
                break;
            else if (counterCells != as || n >= NCPU)
                collide = false;            // At max size or stale
            else if (!collide)
                collide = true;
            //尝试扩容counterCells
            else if (cellsBusy == 0 &&
                     U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                try {
                    if (counterCells == as) {// Expand table unless stale
                        CounterCell[] rs = new CounterCell[n << 1];
                        for (int i = 0; i < n; ++i)
                            rs[i] = as[i];
                        counterCells = rs;
                    }
                } finally {
                    cellsBusy = 0;
                }
                collide = false;
                continue;                   // Retry with expanded table
            }
            //都不符合条件时，重新生成线程探针
            h = ThreadLocalRandom.advanceProbe(h);
        }
        //cellsBusy：counterCells初始化/扩容标识
        //准备初始化counterCells
        else if (cellsBusy == 0 && counterCells == as &&
                 U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
            boolean init = false;
            try {                           // Initialize table
                if (counterCells == as) {
                    CounterCell[] rs = new CounterCell[2];
                    //将数量保存到counterCells节点中
                    rs[h & 1] = new CounterCell(x);
                    counterCells = rs;
                    init = true;
                }
            } finally {
                cellsBusy = 0;
            }
            if (init)
                break;
        }
        //尝试将数量添加到baseCount，避免再次循环
        else if (U.compareAndSwapLong(this, BASECOUNT, v = baseCount, v + x))
            break;                          // Fall back on using base
    }
}
```



## transfer

### 流程

```java
private final void transfer(Node<K,V>[] tab, Node<K,V>[] nextTab) {
    int n = tab.length, stride;
    //stride：每次扩容处理的元素个数
    if ((stride = (NCPU > 1) ? (n >>> 3) / NCPU : n) < MIN_TRANSFER_STRIDE)
        stride = MIN_TRANSFER_STRIDE; // subdivide range
    if (nextTab == null) {            // initiating
        try {
            @SuppressWarnings("unchecked")
            Node<K,V>[] nt = (Node<K,V>[])new Node<?,?>[n << 1];
            nextTab = nt;
        } catch (Throwable ex) {      // try to cope with OOME
            sizeCtl = Integer.MAX_VALUE;
            return;
        }
        nextTable = nextTab;
        transferIndex = n;
    }
    int nextn = nextTab.length;
    //占位节点，表示节点迁移完成或正在迁移
    ForwardingNode<K,V> fwd = new ForwardingNode<K,V>(nextTab);
    //控制扩容下标移动，步进
    boolean advance = true;
    //扩容是否完成
    boolean finishing = false; // to ensure sweep before committing nextTab
    //逆序处理table元素
    for (int i = 0, bound = 0;;) {
        Node<K,V> f; int fh;
        //控制扩容下标移动的相关代码
        while (advance) {
            int nextIndex, nextBound;
            //步进逆序处理下一个元素
            if (--i >= bound || finishing)
                advance = false;
            //已经没有未分配的节点，准备退出扩容任务
            else if ((nextIndex = transferIndex) <= 0) {
                i = -1;
                advance = false;
            }
            //给当前线程分配需要扩容节点的上界（i）和下界（bound）
            else if (U.compareAndSwapInt
                     (this, TRANSFERINDEX, nextIndex,
                      nextBound = (nextIndex > stride ?
                                   nextIndex - stride : 0))) {
                bound = nextBound;
                i = nextIndex - 1;
                advance = false;
            }
        }
        //扩容结束，准备退出扩容任务
        if (i < 0 || i >= n || i + n >= nextn) {
            int sc;
            if (finishing) {
                nextTable = null;
                table = nextTab;
                sizeCtl = (n << 1) - (n >>> 1);
                return;
            }
            //CAS执行当前扩容线程数-1
            if (U.compareAndSwapInt(this, SIZECTL, sc = sizeCtl, sc - 1)) {
                //从尾到头再检查一遍每个哈希桶是否都完成了转移，但这没有必要的
            	//Doug Lea回复这个sweep扫查机制是之前版本遗留下来的，是可以删除掉的
                if ((sc - 2) != resizeStamp(n) << RESIZE_STAMP_SHIFT)
                    return;
                finishing = advance = true;
                i = n; // recheck before commit
            }
        }
        else if ((f = tabAt(tab, i)) == null)
            advance = casTabAt(tab, i, null, fwd);
        else if ((fh = f.hash) == MOVED)
            advance = true; // already processed
        else {
            synchronized (f) {
                if (tabAt(tab, i) == f) {
                    Node<K,V> ln, hn;
                    if (fh >= 0) {
                        int runBit = fh & n;
                        Node<K,V> lastRun = f;
                        for (Node<K,V> p = f.next; p != null; p = p.next) {
                            int b = p.hash & n;
                            if (b != runBit) {
                                runBit = b;
                                lastRun = p;
                            }
                        }
                        if (runBit == 0) {
                            ln = lastRun;
                            hn = null;
                        }
                        else {
                            hn = lastRun;
                            ln = null;
                        }
                        for (Node<K,V> p = f; p != lastRun; p = p.next) {
                            int ph = p.hash; K pk = p.key; V pv = p.val;
                            if ((ph & n) == 0)
                                ln = new Node<K,V>(ph, pk, pv, ln);
                            else
                                hn = new Node<K,V>(ph, pk, pv, hn);
                        }
                        setTabAt(nextTab, i, ln);
                        setTabAt(nextTab, i + n, hn);
                        setTabAt(tab, i, fwd);
                        advance = true;
                    }
                    else if (f instanceof TreeBin) {
                        TreeBin<K,V> t = (TreeBin<K,V>)f;
                        TreeNode<K,V> lo = null, loTail = null;
                        TreeNode<K,V> hi = null, hiTail = null;
                        int lc = 0, hc = 0;
                        for (Node<K,V> e = t.first; e != null; e = e.next) {
                            int h = e.hash;
                            TreeNode<K,V> p = new TreeNode<K,V>
                                (h, e.key, e.val, null, null);
                            if ((h & n) == 0) {
                                if ((p.prev = loTail) == null)
                                    lo = p;
                                else
                                    loTail.next = p;
                                loTail = p;
                                ++lc;
                            }
                            else {
                                if ((p.prev = hiTail) == null)
                                    hi = p;
                                else
                                    hiTail.next = p;
                                hiTail = p;
                                ++hc;
                            }
                        }
                        ln = (lc <= UNTREEIFY_THRESHOLD) ? untreeify(lo) :
                        (hc != 0) ? new TreeBin<K,V>(lo) : t;
                        hn = (hc <= UNTREEIFY_THRESHOLD) ? untreeify(hi) :
                        (lc != 0) ? new TreeBin<K,V>(hi) : t;
                        setTabAt(nextTab, i, ln);
                        setTabAt(nextTab, i + n, hn);
                        setTabAt(tab, i, fwd);
                        advance = true;
                    }
                }
            }
        }
    }
}
```



