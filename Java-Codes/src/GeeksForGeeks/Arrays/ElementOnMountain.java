package GeeksForGeeks.Arrays;

//https://practice.geeksforgeeks.org/problems/unsorted-array4925/1
/*
Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ElementOnMountain {

    public static int findElement(int arr[], int n){
        List<Integer> maxToLeft = Arrays.asList(new Integer[n]);
        List<Integer> minToRight = Arrays.asList(new Integer[n]);

        maxToLeft.set(0, Integer.MIN_VALUE);
        minToRight.set(n-1, Integer.MAX_VALUE);

        for (int i=1; i<n; i++) {
            maxToLeft.set(i, Math.max(maxToLeft.get(i-1), arr[i-1]));
            minToRight.set(n-1-i, Math.min(minToRight.get(n-i), arr[n-i]));
        }

        for (int i=1; i<n-1; i++) {
            if (arr[i] >= maxToLeft.get(i) && arr[i] <= minToRight.get(i)) {
                return arr[i];
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int arr[] ={11, 9, 12};
        System.out.println(findElement(arr, arr.length));
    }
}
