package LeetCode.Arrays;

/**
 * https://leetcode.com/problems/jump-game/
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */

public class CanJumpToLast {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int i;
        for (i=0; i<=maxReach && i < nums.length; i++) {
            //System.out.println(maxReach);
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return i == nums.length;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,1,0,4};
        CanJumpToLast canJumpToLast = new CanJumpToLast();
        canJumpToLast.canJump(arr);
    }

}
