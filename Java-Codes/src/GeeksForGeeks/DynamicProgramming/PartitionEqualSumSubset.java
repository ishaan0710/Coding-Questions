package GeeksForGeeks.DynamicProgramming;


import java.util.Arrays;

/**
 *
 * https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
 *
 * Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.
 */
public class PartitionEqualSumSubset {

    static int equalPartition(int N, int arr[])
    {
        int sumOfArray = 0;
        for (int j : arr) {
            sumOfArray += j;
        }
        if (sumOfArray % 2 != 0)
            return 0;
        int sumRequired = sumOfArray / 2;
        int dp[][] = new int[N][sumRequired + 1];
        for (int i=0; i<N; i++)
            Arrays.fill(dp[i], -1);
        return checkSumPossible(arr, N, 0, sumRequired, dp) ? 1 : 0;
    }

    private static boolean checkSumPossible(int[] arr, int n, int pos, int sumRequired, int dp[][]) {
        if (pos == n)
            return false;
        if (sumRequired == 0)
            return true;
        if (sumRequired < 0)
            return false;
        if (dp[pos][sumRequired] != -1) {
            return dp[pos][sumRequired] == 1;
        }
        boolean possible = checkSumPossible(arr, n, pos+1, sumRequired, dp) || checkSumPossible(arr, n, pos + 1, sumRequired - arr[pos], dp);
        dp[pos][sumRequired] = possible ? 1 : 0;
        return possible;
    }

    public static void main(String[] args) {
        int arr[] = {1, 15, 11, 5};
        System.out.println(equalPartition(4, arr));
    }
}
