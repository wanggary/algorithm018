package com.wsj.algorithm.week4.No_searchInRotatedSortedArray;

/**
 * 给你一个整数数组 nums ，和一个整数 target 。
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 */
public class searchRotatedSortedArray {
    /** 二分查找，考虑4种情况
     * 1.索引0-mid升序，且target在0-mid之间
     * 2.索引mid到最后也是升序，target在mid之后
     * 3.num[mid] < mid[0],0-mid之间发生了旋转，target在旋转位置到mid之间
     * 4.num[mid] < mid[0],0-mid之间发生了旋转，target在0到旋转位置之间
     */

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return target == nums[0]? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;

            if (target == nums[mid]) {
                return mid;
            }

            // 0-mid升序
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 0-mid之间有旋转
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
