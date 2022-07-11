package GeeksForGeeks.DynamicProgramming;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/max-length-chain/1
 *
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the second number.
 * A pair (c, d) can follow another pair (a, b) if b < c.
 * Chain of pairs can be formed in this fashion. You have to find the longest chain which can be formed from the given set of pairs.
 */

public class MaxChainLength {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private int getMaxChainLength(int maxNumberInChain, int pos, Pair arr[], Map<Pair, Integer> dp_value, int n) {
        if (pos == n)
            return 0;
        Pair state = new Pair(pos, maxNumberInChain);
        if (dp_value.containsKey(state)) {
            return dp_value.get(state);
        }
        int maxChainLength;
        if (arr[pos].x <= maxNumberInChain) {
            maxChainLength = getMaxChainLength(maxNumberInChain, pos + 1, arr, dp_value, n);
            dp_value.put(state, maxChainLength);
            return maxChainLength;
        }
        maxChainLength = Math.max(getMaxChainLength(maxNumberInChain, pos + 1, arr, dp_value, n),
                                        1 + getMaxChainLength(arr[pos].y, pos + 1, arr, dp_value, n));
        dp_value.put(state, maxChainLength);
        return maxChainLength;
    }

    int maxChainLength(Pair arr[], int n)
    {
        Map<Pair, Integer> dp_value = new HashMap<>();
        Arrays.sort(arr, Comparator.comparingInt(o -> o.x));
        return getMaxChainLength(Integer.MIN_VALUE, 0, arr, dp_value, n);
    }

    public static void main(String[] args) {
        Pair arr[] = {new Pair(5, 24), new Pair(39,60), new Pair(15,28), new Pair(27, 40), new Pair(50, 90)};
        System.out.println(new MaxChainLength().maxChainLength(arr, arr.length));
    }
}
