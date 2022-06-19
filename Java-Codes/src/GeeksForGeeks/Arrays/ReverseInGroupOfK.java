package GeeksForGeeks.Arrays;

// Given an array arr[] of positive integers of size N. Reverse every sub-array group of size K.
// https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1

import java.util.ArrayList;
import java.util.Arrays;

class ReverseInGroupOfK {

    static void reverse(ArrayList<Integer> arr, int start, int end) {
        while(start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int start = 0;
        while(start + k - 1 < n) {
            reverse(arr, start, start + k - 1);
            start +=k;
        }
        reverse(arr, start, n-1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        reverseInGroups(input,10,3);
        System.out.println(input);
    }
}
