package GeeksForGeeks.DynamicProgramming;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1
 *
 * Given a number N. Find the minimum number of operations required to reach N starting from 0. You have 2 operations available:
 *
 * Double the number
 * Add one to the number
 *
 */

public class MinimumOperations {

    int[] minOperation;

    public int minOperation(int n)
    {
        minOperation = new int[n+1];
        Arrays.fill(minOperation, Integer.MAX_VALUE);

        minOperation[0] = 0;
        minOperation[1] = 1;
        if (n < 2)
            return minOperation[n];

        for (int i=0; i<n;i++) {
            int addOne = i+1;
            int doubleNum = i*2;
            if (addOne <= n) {
                minOperation[addOne] = Math.min(minOperation[addOne], minOperation[i] + 1);
            }
            if (doubleNum <= n) {
                minOperation[doubleNum] = Math.min(minOperation[doubleNum], minOperation[i] + 1);
            }
            if (minOperation[n] != Integer.MAX_VALUE)
                return minOperation[n];
        }
        return minOperation[n];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumOperations().minOperation(8));
        //System.out.println(Arrays.toString(minOperation));
    }
}
