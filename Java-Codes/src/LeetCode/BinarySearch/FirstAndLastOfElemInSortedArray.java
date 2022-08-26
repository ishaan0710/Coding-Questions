package LeetCode.BinarySearch;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class FirstAndLastOfElemInSortedArray {

    int findPos(int low, int high, int[] nums, int target, int direction) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            int adj = mid + direction;
            if (adj < 0 || adj >= nums.length) {
                return mid;
            }
            if (nums[adj] != target) {
                return mid;
            }
            if (direction > 0) {
                return findPos(mid + 1, high, nums, target, direction);
            } else {
                return findPos(low, mid - 1, nums, target, direction);
            }
        }

        if (nums[mid] > target) {
            return findPos(low, mid - 1, nums, target, direction);
        } else {
            return findPos(mid + 1, high, nums, target, direction);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int high = findPos(0, nums.length - 1, nums, target, 1);
        int low = findPos(0, nums.length - 1, nums, target, -1);
        int[] ans = new int[2];
        ans[0] = low;
        ans[1] = high;
        return ans;
    }

}
