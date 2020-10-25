package com.wsj.prictise.chap1_ArrayAndList.rotateArray189;


public class RotateArray {

    /**
     * 旋转数组，暴力法求解
     * 时间复杂度: O(n * k)
     */
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = tmp;
        }
    }

    /**
     * 反转数组法
     * 旋转数组 k 次， k%n个尾部元素会被移动到头部，剩下的元素会被向后移动
     * 1.所有元素反转
     * 2.反转前k个元素
     * 3.再反转后面n - k个元素
     *
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     * 时间复杂度：O(n)
     */
    public void rotate2(int[] nums, int k) {
        // 防止k比nums长度大
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;

            start++;
            end--;
        }
    }
}
