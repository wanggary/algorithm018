学习笔记

深度优先遍历

代码模板

递归

```text
visited = set()
def dfs(node, visited):
    if node in visited:
        #已访问
        return;
visited.add(node)

#处理当前节点
...
#向下递归
for next_node in node.children():
    if not next_node in visited:
        dfs(next_node, visited)
```

非递归

```text
visited = set()
def dfs(node, visited):
    visited.add(node)

#处理当前节点
...
#向下递归
for next_node in node.children():
    if not next_node in visited:
        dfs(next node, visited)
```

二叉树深度递归

```java
// 二叉树的深度优先遍历
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    // 递归终止
    if(root == null) {
        retutn allResults;
    }
    
    travel(root, 0, allResults);
    return allResults;
}

private void travel(TreeNode root, int level, List<List<Integer>> results) {
    // 当前层添加一个新List
    if (results.size() == level) {
        results.add(new ArrayList<>());
    }
    results.get(level).add(root.val);
    if (root.left != null) {
        travel(root.left, level + 1, results);
    }
    if (root.right != null) {
        travel(root.right, level + 1, results);
    }
}
```



广度优先遍历

无向图中两个顶点之间的最短路径长度，可以通过广度优先遍历得到 

需要一个队列来保存访问过的节点的顺序，以便按这个顺序来访问这些节点的邻接节点 

代码模板

```text
def bfs(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
```

二叉树广度优先遍历

```java
// 二叉树的广度优先遍历
public List<List<Integer>> levelOrder(TreeNode root) {    
    List<List<Integer>> allResults = new ArrayList<>();        
    if (root == null) {        
        return allResults;    
    }        
    // 双端队列    
    Queue<TreeNode> nodes = new LinkedList<>();    
    nodes.add(root);        
    while(!nodes.isEmpty()) {        
        // 先保存当前队列的长度        
        int size = nodes.size();        
        // 未访问过的节点        
        List<Integer> results = new ArrayList<>();        
        // 处理        
        for (int i = 0; i < size; i++) {            
            TreeNode node = nodes.poll();            
            results.add(node.val);                        
            if(node.left != null) {                
                nodes.add(node.left);            
            }              
            if(node.right!= null) {                
                nodes.add(node.right);            
            }        
        }        
        allResults.add(results);    
    }    
    return allResults;
}
```



二分查找

前提：

1.目标函数是单调递增或递减的

2.存在上下界

3.能通过索引访问

代码模板

```text
left = 0, right = len(array) - 1

while left <= right
    mid = (left + right)/2
    if array[mid] == target
        break or return result
    else if array[mid] < target
        left = mid + 1
    else
        right = mid -1
```

