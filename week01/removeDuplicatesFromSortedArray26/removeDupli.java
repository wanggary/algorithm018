package com.wsj.prictise.chap1_ArrayAndList.removeDuplicatesFromSortedArray26;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 *
 */
public class removeDupli {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }

        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                if(i + 1 < j){
                    nums[i + 1] = nums[j];
                }
                i++;
            }
            j++;
        }

        return i + 1;
    }
}
