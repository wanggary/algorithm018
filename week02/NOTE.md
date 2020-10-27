学习笔记

HashMap

```text
* 允许使用null键和null值，不保证顺序
* 所有key构成的集合是Set：无序、不重复，所以key所在的类要重写equals()和hashCode()方法
* 所有的value构成的集合是Collection：无序、可重复，所以value所在的类要重写equals()
* 所有entry构成的集合是Set
* HashMap判断两个key相等的标准：两个key通过equals()方法返回true，hashCode值也相等
* HashMap判断两个value相等的标准：两个value通过equals()方法返回true
```

put方法:

```text
put方法内部调用方法putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict)
hash:key的hash值
key:put的key
value:put的value
```





Hash Table

```text
哈希表（散列表）是根据关键码值（key/value）直接进行访问的数据结构
通过把key value映射到表中的一个位置来访问纪录，以加快查找的速度
通过Hash函数把值映射到某一个位置，即index
```

