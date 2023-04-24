package LeetCode.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        int[] output = new int[n];

        prefixProduct[0] = 1;
        suffixProduct[n-1] = 1;

        for (int i=1; i<n; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
            suffixProduct[n-1-i] = suffixProduct[n-i] * nums[n-i];
        }

        for (int i=0; i<n; i++) {
            output[i] = prefixProduct[i] * suffixProduct[i];
        }
        return output;
    }
}
