package LeetCode.Arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 */

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int noOfDuplicates = 0;
        int prevValue = -101;
        int currValue;
        for(int i=0; i<nums.length; i++) {
            currValue = nums[i];
            if (prevValue == currValue) {
                noOfDuplicates ++;
            } else {
                nums[i - noOfDuplicates] = nums[i];
                prevValue = currValue;
            }
        }
        return nums.length - noOfDuplicates;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
    }
}
