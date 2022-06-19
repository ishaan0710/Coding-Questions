package GeeksForGeeks.Arrays;

// https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
//Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array.
//Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.


class EquilibriumPoint {

    public static int equilibriumPoint(long arr[], int n) {
        long sumOfArray = 0;
        for (int i=0; i<n; i++) {
            sumOfArray += arr[i];
        }
        long sumOnLeft = 0;
        for (int i=0; i<n;i++) {
            if (sumOnLeft == sumOfArray - sumOnLeft - arr[i]) {
                return i + 1;
            }
            sumOnLeft += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        long arr[] = {1, 2, 4 ,3};
        System.out.println(equilibriumPoint(arr, arr.length));
    }
}
