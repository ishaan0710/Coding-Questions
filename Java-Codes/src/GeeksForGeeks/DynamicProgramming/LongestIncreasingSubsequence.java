package GeeksForGeeks.DynamicProgramming;

import java.util.Arrays;

/**
 * Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.
 *
 * https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
 */

public class LongestIncreasingSubsequence {

    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        int lis[] = new int[size];
        Arrays.fill(lis, 1);
        if (size == 0)
            return 0;
        for (int i=1; i<size; i++) {
            for (int j=0; j<i; j++) {
                if (a[j] < a[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        System.out.println(Arrays.toString(lis));
        int max = Integer.MIN_VALUE;
        for (int i=0; i<size; i++)
            max = Math.max(max, lis[i]);
        return max;
    }

    public static void main(String[] args) {
        int a[] = {2, 10, 5, 1, 8, 6, 6, 6, 5};
        longestSubsequence(a.length, a);
    }
}
