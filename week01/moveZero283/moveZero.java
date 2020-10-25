package com.wsj.prictise.chap1_ArrayAndList.moveZero283;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class moveZero {
    public void moveZeroes(int[] nums) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            int tmp;
            if (nums[j] != 0) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                i++;
            }
        }
    }
}
