package GeeksForGeeks.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * Note that we have only one quantity of each item.
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively.
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or dont pick it (0-1 property).
 */

public class KnapSack {

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static int getMaxValue(int remainingWeight, int pos, int wt[], int val[], int n, Map<Pair, Integer> dp) {
        if (pos == n)
            return 0;
        Pair state = new Pair(pos, remainingWeight);
        int maxValue;
        if (dp.containsKey(state)) {
            return dp.get(state);
        }
        if (wt[pos] > remainingWeight) {
            maxValue = getMaxValue(remainingWeight, pos + 1, wt, val, n, dp);
            dp.put(state, maxValue);
            return maxValue;
        }

        maxValue =  Math.max(val[pos] + getMaxValue(remainingWeight - wt[pos], pos + 1, wt, val, n, dp),
                getMaxValue(remainingWeight, pos + 1, wt, val, n, dp));
        dp.put(state, maxValue);
        return maxValue;
    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        Map<Pair, Integer> dp = new HashMap<>();
        return getMaxValue(W, 0, wt, val, n, dp);
    }


    public static void main(String[] args) {

    }
}
