package LeetCode.Arrays;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */

//Alter Use HashMap - Check if other num exists -> complexity O(n) both space & time
// Current solution - Time Complexity O(nlog(n)) Space O(n)
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int end = sortedNums.length-1;
        int[] result = new int[2];
        for (int start=0; start < end;) {
            int currSum = sortedNums[start] + sortedNums[end];
            if (target == currSum) {
                int startPos = -1;
                int endPos = -1;
                for (int i=0; i<nums.length; i++) {
                    if (nums[i] == sortedNums[start] && startPos == -1) {
                        startPos = i;
                    } else if (nums[i] == sortedNums[end]) {
                        endPos = i;
                    }
                }
                result[0] = Math.min(startPos, endPos);
                result[1] = Math.max(startPos, endPos);
                return result;
            } else if (currSum < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }
}
