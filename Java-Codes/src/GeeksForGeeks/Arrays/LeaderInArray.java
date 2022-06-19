package GeeksForGeeks.Arrays;
//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
// Given an array A of positive integers. Your task is to find the leaders in the array.
// An element of array is leader if it is greater than or equal to all the elements to its right side.
// The rightmost element is always a leader.

import java.util.ArrayList;
import java.util.Collections;

class LeaderInArray {

    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> leadersFound = new ArrayList<>();
        int maxToTheRight = -1;
        for (int i=n-1; i>=0; i--) {
            if (arr[i] >= maxToTheRight) {
                maxToTheRight = arr[i];
                leadersFound.add(arr[i]);
            }
        }
        Collections.reverse(leadersFound);
        return leadersFound;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0};
        System.out.println(leaders(arr, arr.length));
    }

}
