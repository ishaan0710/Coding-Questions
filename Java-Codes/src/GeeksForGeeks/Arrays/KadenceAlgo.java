package GeeksForGeeks.Arrays;

/**
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
 */

class KadenceAlgo {

    static long maxSubarraySum(int arr[], int n){
        long maxSum = Long.MIN_VALUE;
        long currSum = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > maxValue)
                maxValue = arr[i];
            if (currSum + arr[i] > 0) {
                currSum += arr[i];
                maxSum = Math.max(maxSum, currSum);
            } else {
                currSum = 0;
            }
        }
        if (maxValue < 0)
            return maxValue;
        return maxSum;
    }

    public static void main(String[] args) {
        int N = 5;
        int arr[] = {-1,-2, 5,-4, 5};
        System.out.println(maxSubarraySum(arr, N));
    }


}
