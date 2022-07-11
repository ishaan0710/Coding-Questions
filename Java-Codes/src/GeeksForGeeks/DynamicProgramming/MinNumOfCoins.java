package GeeksForGeeks.DynamicProgramming;

/**
 *https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1
 *
 * Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
 * Find the minimum number of coins and/or notes needed to make the change for Rs N.
 */
import java.util.*;

public class MinNumOfCoins {

    static List<Integer> minPartition(int N)
    {
        ArrayList<Integer> denominations = new ArrayList<>(Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000));
        List<Integer> coinsUsed = new ArrayList<>();
        Collections.reverse(denominations);
        int remaining = N;
        for (Integer denomination : denominations) {
            while (remaining >= denomination) {
                coinsUsed.add(denomination);
                remaining -= denomination;
            }
        }
        return coinsUsed;
    }
}
