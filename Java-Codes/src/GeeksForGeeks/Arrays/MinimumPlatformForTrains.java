package GeeksForGeeks.Arrays;

// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

import java.util.Arrays;

/**
 * Given arrival and departure times of all trains that reach a railway station.
 * Find the minimum number of platforms required for the railway station so that no train is kept waiting.
 * Consider that all the trains arrive on the same day and leave on the same day.
 * Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other.
 * At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.
 */

class MinimumPlatformForTrains {

    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int maxPlatform = 0;
        int arrStart = 0;
        int deptStart = 0;
        int currTrains = 0;
        while (arrStart < n && deptStart < n) {
            if (arr[arrStart] <= dep[deptStart]) {
                currTrains ++;
                maxPlatform = Math.max(maxPlatform, currTrains);
                arrStart ++;
            } else {
                currTrains --;
                deptStart ++;
            }
        }
        while (arrStart < n) {
            currTrains++;
            maxPlatform = Math.max(maxPlatform, currTrains);
            arrStart++;
        }
        return maxPlatform;
    }

    public static void main(String[] args) {
        int arr[] = {900, 1100, 1235};
        int dep[] = {1000, 1200, 1240};
        System.out.println(findPlatform(arr, dep, arr.length));
    }
}
