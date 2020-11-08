package com.wsj.algorithm.week3.No77_combinations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // 不满足条件，结果为空集合
        if (k <= 0 || n < k) {
            return result;
        }
        // n==k, 就是1-k
        if (n == k) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                tmpList.add(i);
            }
            result.add(tmpList);
            return result;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, result);
        return result;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终结
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            // 先添加第一个数
            path.add(i);
            // 向下递归
            dfs(n, k, i + 1, path, res);

            path.removeLast();
        }
    }

    private void dfs2(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终结
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            // 先添加第一个数
            path.add(i);
            // 向下递归
            dfs2(n, k, i + 1, path, res);

            path.removeLast();
        }
    }
}
