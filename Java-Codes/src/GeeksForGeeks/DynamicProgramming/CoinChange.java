package GeeksForGeeks.DynamicProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * https://practice.geeksforgeeks.org/problems/coin-change2448/1
 *
 * Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins.
 */

public class CoinChange {


    public long count(int S[], int m, int n) {
        long[] waysToMake = new long[n+1];
        Arrays.sort(S);
        waysToMake[0] = 1;
        for (int i=0; i<m; i++) {
            for (int j=S[i]; j<=n; j++) {
                waysToMake[j] += waysToMake[j-S[i]];
            }
        }
        return waysToMake[n];
    }

    public static void main(String[] args) {
        int S[] = {2,3,5, 6};
        System.out.println(new CoinChange().count(S, 4, 10));
    }

}
