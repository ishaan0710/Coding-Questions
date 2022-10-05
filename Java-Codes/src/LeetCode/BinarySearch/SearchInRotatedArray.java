package LeetCode.BinarySearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class SearchInRotatedArray {

    int mod(int x, int y) {
        return x % y > 0 ? x % y : (x % y) + y;
    }

    int findPivot(int low, int high, int[] nums) {
        int mid = (low + high) / 2;
        int prev = (mid - 1) % nums.length;
        int next = (mid + 1) % nums.length;

        if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
            return mid;
        }
        if (nums[mid] > nums[nums.length - 1]) {
            return findPivot(mid + 1, high, nums);
        }
        return findPivot(low, mid -1, nums);
    }

    int binarySearch(int low, int high, int[] nums, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[high] > nums[low]) {
            if (nums[mid] > target) {
                return binarySearch(low, mid - 1, nums, target);
            } else {
                return binarySearch(mid + 1, high, nums, target);
            }
        }

        if (nums[mid] > nums[low]) {
            if (target > nums[mid] || target < nums[high]) {
                return binarySearch(mid + 1, high, nums, target);
            } else {
                return binarySearch(low, mid - 1, nums, target);
            }
        } else {
            if (target > nums[mid] && target < nums[low]) {
                return binarySearch(mid + 1, high, nums, target);
            } else {
                return binarySearch(low, mid - 1, nums, target);
            }
        }

    }

    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,1,2};
       // System.out.println((-1 % 4));
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        int x = searchInRotatedArray.search(nums, 7);
        System.out.println(x);
    }


}
