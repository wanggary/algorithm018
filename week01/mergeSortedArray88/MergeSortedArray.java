package com.wsj.prictise.chap1_ArrayAndList.mergeSortedArray88;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class MergeSortedArray {
    /**
     * 双指针从前往后
     * 时间复杂度O(m + n)
     * 空间复杂度O(m)
     * 需要将num1的数组元素先复制一份，再比较大小，从num1的最前端开始赋值
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tmpNums = new int[m];
        System.arraycopy(nums1, 0, tmpNums, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while (p1 < m && p2 < n) {
//            if (tmpNums[p1] < nums2[p2]) {
//                nums1[p] = tmpNums[p1];
//                p1++;
//                p++;
//            } else {
//                nums1[p] = nums2[p2];
//                p2++;
//                p++;
//            }

            // 三元简洁写法
            nums1[p++] = (tmpNums[p1] < nums2[p2]) ? tmpNums[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(tmpNums, p1, nums1, p, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p, m + n - p1 - p2);
        }
    }

    /**
     * 双指针从后往前
     * 时间复杂度O(m + n)
     * 空间复杂度O(1)
     * 因为num1数组大小为m+n，num1的前m个元素才是有效位，m之后不参与比较
     * 所以从num1最尾端开始，把较大的元素放num1的尾端开始放，就不需要另外拷贝num1的元素
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
//            if (nums2[p2] > nums1[p1]) {
//                nums1[p] = nums2[p2];
//                p2--;
//                p--;
//            } else {
//                nums1[p] = nums1[p1];
//                p1--;
//                p--;
//            }

            //三元
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}
