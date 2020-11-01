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
key:要put的key
value:要put的value
onlyIfAbsent：如果是true，put时不改变已有的值，此处传入false

如果table为空或长度为0，则调用resize扩容，初始化默认大小16位
然后根据key值计算hash值得到插入的数组索引i
如果该索引处为空，则创建一个新Node直接插入
如果索引处不为空，判断key是否存在，
如果key存在，直接覆盖value
如果key不存在，判断该索引处是否为TreeNode，
如果是，则为红黑树调用putTreeVal插入
如果不是，则为链表，判断链表是否大于8
如果不大于8则链表插入，key存在则直接覆盖
如果大于8则调用treeifyBin转换红黑树插入

键值对插入HashMap后判断插入后大小是否超过最大容量threshold
如果超过则调用resize进行扩容
```





Hash Table

```text
哈希表（散列表）是根据关键码值（key/value）直接进行访问的数据结构
通过把key value映射到表中的一个位置来访问纪录，以加快查找的速度
通过Hash函数把值映射到某一个位置，即index

哈希表的访问、插入、删除的平均时间复杂度都是O(1), 最坏时间复杂度是O(n)
```

树

二叉树的遍历：

```text
前序遍历：根-左-右
中序遍历：左-根-右
后序遍历：左-右-根
```

代码模板：

```text
// 前序
def preorder(self, root):
	if root:
		self.traverse_path.append(root.val)
		self.preorder(root.left)
		self.preorder(root.right)

// 中序
def inorder(self, root):
	if root:
		self.inorder(root.left)
		self.traverse_path.append(root.val)
		self.inorder(root.right)
	
// 后序
def postorder(self, root):
	if root:
		self.postorder(root.left)
		self.postorder(root.right)
		self.traverse_path.append(root.val)
```



二叉搜索树

```text
是指一颗空树或者具有下列性质的二叉树：
1.左子树上所有节点的值均小于它的根节点的值
2.右子树上所有节点的值均大于它的根节点的值
3.左右子树也分别为二叉搜索树
```

```text
查询和插入的时间复杂度都是O(logn)
```



堆

```text
Heap: 可以迅速找到一堆数中的最大或者最小值的数据结构
根节点最大的是大顶堆，根节点最小的是小顶堆
常见的堆有二叉堆、斐波那契堆
```



```text
如果二叉堆通过数组实现
二叉堆第一个元素在数组中的索引为0，则
索引为i的左孩子的索引是（2*i+1）
索引为i的右孩子的索引是（2*i+2）
索引为i的父节点的索引是floor((i-1)/2)
```

```text
二叉堆插入元素最坏情况的时间复杂度就是堆的深度，也就是二叉树的深度log2n
删除的时间复杂度是logn
```

