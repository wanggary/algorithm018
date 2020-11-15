package com.wsj.algorithm.week4.No55_jumpGame;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class JumpGame {
    /**
     * 使用贪心算法
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        // 当前最远可以跳到的位置
        int jumpMax = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= jumpMax) {
                jumpMax = Math.max(jumpMax, i + nums[i]);
                // 如果最远可以跳到的位置超过了数组长度，则返回true
                if (jumpMax >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
