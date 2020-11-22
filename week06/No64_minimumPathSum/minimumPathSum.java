package com.wsj.algorithm.week6.No64_minimumPathSum;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class minimumPathSum {
    /**
     * 类似不同路径问题，网格上每个点都只有从左边过来或从上边过来两条路径，
     * 所以当前点(i, j)开始的最小路径和 = 左边点(i, j - 1)和上边点(i - 1, j)过来的两个路径和的较小者 + 当前点的值
     * DP方程：f[i][j] = min(f[i][j - 1], f[i - 1][j]) + grid[i][j]
     * 又只能向右和向下走，所以第一行的点只考虑从左边过来的路径（i - 1）,第一列上的点只考虑从上过来的路径(j - 1)
     * 且可以直接修改原矩阵，用当前点的最小路径和替换当前点的值，这样最终矩阵的最小路径和就是最右下的点的值
     * 时间复杂度O(m * n), 空间复杂度O(1)
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第一个点的路径和就是它原本的值
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                // 第一行上的点，只能从左边过来
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                // 第一列上的点，只能从上边过来
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                // 从左过来的路径和 和 从上过来的路径和的最小值
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
