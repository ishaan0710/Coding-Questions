package LeetCode.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find a
 * subarray that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */

public class MaxProductSubarray {

    public int maxProduct(int[] nums) {

        int n = nums.length;

        int maxProduct = 1;
        int minProduct = 1;
        int ans = Integer.MIN_VALUE;

        for (int num : nums) {

            maxProduct = Math.max((num > 0 ? maxProduct : minProduct) * num, num);
            minProduct = Math.min((num > 0 ? minProduct : maxProduct) * num, num);

            ans = Math.max(maxProduct, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        int[] nums = {-3,-3,-1};
        System.out.println(maxProductSubarray.maxProduct(nums));
    }

}
