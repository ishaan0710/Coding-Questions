package GeeksForGeeks.Arrays;

import java.util.Arrays;

/**
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
 https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
 */

class CountTriplets {

    public static int countTriplet(int arr[], int n) {
        // boxed used to convert primitive int to Integer
        //List<Integer> list = GeeksForGeeks.Arrays.stream(arr)
          //      .boxed().toList();
        //Collections.sort(list);
        Arrays.sort(arr);
        int tripletCount = 0;
        for (int i=0; i<n-2; i++) {
            int z = i+2;
            for (int j=i+1; j<n-1; j++) {
                int sum = arr[i] + arr[j];
                System.out.println("Check i=" + i + " j=" + j + " sum=" + sum);
                while(z < n && sum > arr[z]) {
                    System.out.println("arr z(" + z + ") = " + arr[z]);
                    z++;
                }
                if( z == n ) {
                    break;
                }
                if (arr[z] == sum)
                    tripletCount++;

            }
        }
        return tripletCount;
    }

    public static void main(String args[]) {
        int arr[] = {12, 8, 2, 11, 5, 14, 10};
        System.out.println(countTriplet(arr, 7));
    }

}
