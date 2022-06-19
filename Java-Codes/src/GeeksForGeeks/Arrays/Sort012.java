package GeeksForGeeks.Arrays;

//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
// Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

import java.util.Arrays;

class Sort012 {

    static void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void sort012(int a[], int n)
    {

        int currPos = 0;
        int startOfOnes = -1;
        int leftOfTwos = n-1;

        while(a[leftOfTwos] == 2) {
            leftOfTwos--;
        }

        for (currPos = 0; currPos<n; currPos++) {
            if (a[currPos] == 0) {
                if (startOfOnes >= 0) {
                    swap(a, startOfOnes, currPos);
                    startOfOnes ++;
                    if(a[startOfOnes] != 1) {
                        startOfOnes = -1;
                    }
                    currPos --;
                }
                continue;
            } else if (a[currPos] == 1) {
                if (startOfOnes == -1)
                    startOfOnes = currPos;
                continue;
            } else if (a[currPos] == 2) {
                if (currPos < leftOfTwos) {
                    swap(a, currPos, leftOfTwos);
                    leftOfTwos--;
                    currPos--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0,0,0,0,0};
        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }


}
