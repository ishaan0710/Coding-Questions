package GeeksForGeeks.Arrays;

//https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates.
 * There are M students, the task is to distribute chocolate packets among M students such that :
 * 1. Each student gets exactly one packet.
 * 2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
 */

class ChocolateDistribution {

    public static long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        Collections.sort(a);
        long minDifference = Long.MAX_VALUE;

        for(int i=0; i<=n-m; i++) {
            minDifference = Math.min(a.get((int) (i+m-1)) - a.get(i), minDifference);
        }
        return minDifference;
    }

    public static void main(String[] args) {
        ArrayList<Long> chocolatePackets = new ArrayList<>(
                Arrays.asList(3L, 4L, 1L, 9L, 56L, 7L, 9L, 12L)
        );
        System.out.println(findMinDiff(chocolatePackets, 8, 5));
    }
}
