package GeeksForGeeks.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that
 * the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence.
 *
 * https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
 */

public class MaximumSumIncreasingSubSeq {

    public int maxSumIS(int arr[], int n)
    {
        int maxSumIncreasingSubSeq[] = new int[n];
        for(int i=-0; i<n; i++)
            maxSumIncreasingSubSeq[i] = arr[i];
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    maxSumIncreasingSubSeq[i] = Math.max(maxSumIncreasingSubSeq[i], maxSumIncreasingSubSeq[j] + arr[i]);
                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<n; i++)
            maxValue = Math.max(maxValue, maxSumIncreasingSubSeq[i]);
        return maxValue;
    }

}
