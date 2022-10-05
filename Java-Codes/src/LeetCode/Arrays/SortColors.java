package LeetCode.Arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 */

public class SortColors {

    void swap(int[] nums, int x, int y) {
        System.out.println("swap -> " + x + " " + y);
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int endOfZeroes = -1;
        int startOfTwos = n;

        for (int curr = 0; curr < startOfTwos; curr++) {
            switch (nums[curr]) {
                case 0 :
                    endOfZeroes ++;
                    swap(nums, curr, endOfZeroes);
                    break;
                case 1:
                    break;
                case 2:
                    startOfTwos--;
                    swap(nums, curr, startOfTwos);
                    curr--;
                    break;
                default:
                     break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
