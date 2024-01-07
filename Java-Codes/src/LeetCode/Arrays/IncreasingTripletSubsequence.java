package LeetCode.Arrays;

/**
 * <a href=https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75 />
 *
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i]
 * < nums[j] < nums[k]. If no such indices exists, return false.
 */

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int[] leastNumberToLeft = new int[nums.length];
        int[] greatestNumberToRight = new int[nums.length];

        leastNumberToLeft[0] = Integer.MAX_VALUE;
        greatestNumberToRight[nums.length-1] = Integer.MIN_VALUE;

        for (int i=1; i<nums.length; i++) {
            leastNumberToLeft[i] = Math.min(leastNumberToLeft[i-1], nums[i-1]);
        }

        for (int i=nums.length-2; i>=0; i--) {
            greatestNumberToRight[i] = Math.max(greatestNumberToRight[i+1], nums[i+1]);
        }

        for (int i=1; i<nums.length-1; i++) {
            if (leastNumberToLeft[i] < nums[i] && greatestNumberToRight[i] > nums[i]) {
                System.out.println("i=" + i);
                return true;
            }
        }
        return false;
    }

}
