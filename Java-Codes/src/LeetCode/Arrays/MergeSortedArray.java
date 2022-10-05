package LeetCode.Arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

public class MergeSortedArray {

    private void insert(int[] nums, int pos, int x) {
        for (int i=nums.length-1; i>pos; i--) {
            nums[i] = nums[i-1];
        }
        nums[pos] = x;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergedIter = 0;
        int iter2 = 0;
        int iter1=0;
        while (iter1 < m && iter2 < n) {
            if (nums2[iter2] < nums1[mergedIter]) {
                insert(nums1, mergedIter, nums2[iter2]);
                iter2++;
            } else {
                iter1++;
            }
            mergedIter++;
        }

        while (mergedIter < m + iter2) {
            mergedIter++;
        }

        while (iter2 < n) {
            nums1[mergedIter] = nums2[iter2];
            mergedIter++;
            iter2++;
        }

    }

    public static void main(String[] args) {
        int nums1[] = {4,0,0,0,0,0};
        int nums2[] = {1,2,3,5,6};
        new MergeSortedArray().merge(nums1,1, nums2, 5);
    }
}
