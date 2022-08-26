package LeetCode.Arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 */

public class FirstMissingNum {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i=0; i<n; i++) {

            int val = Math.abs(nums[i]);

            if (val > 0 && val <= n) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (n + 1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i=0; i<n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,4,6};
        FirstMissingNum firstMissingNum = new FirstMissingNum();
        System.out.println(firstMissingNum.firstMissingPositive(arr));
    }
}
