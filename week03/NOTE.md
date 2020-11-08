学习笔记

递归代码模板：

```java
public void recur(int level, int param) { 
  // terminator 递归终结条件
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 当前层逻辑
  process(level, param); 
  // drill down 向下递归到下一层
  recur( level: level + 1, newParam); 
  // restore current status 清理当前层
 
```

```text
找最近最简方法，拆分成重复子问题
```

分治代码模板

```java
private static int divide_conquer(Problem problem, ) {
  // terminator 没有子问题可分了
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  // 拆分子问题
  subProblems = split_problem(problem)
  // 向下递归解决子问题
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  // 组合子问题的结果
  result = process_result(res0, res1);
  // revert
    
  return result;
}
```



本周较忙，且递归问题需要较多时间理解消化，作业做的题较少，后续要在空闲时间补上，递归的题本身也需要多看多练