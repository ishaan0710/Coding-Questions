package GeeksForGeeks.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://practice.geeksforgeeks.org/problems/edit-distance3702/1
 *
 * Given two strings s and t. Return the minimum number of operations required to convert s to t.
 * The possible operations are permitted:
 *
 * Insert a character at any position of the string.
 * Remove any character from the string.
 * Replace any character from the string with any other character.
 */

public class MatchStrings {

    public int editDistance(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        int x =  findOperations(s, t, 0, 0, dp);

        for (int i=0; i<s.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return x;
    }

    private int findOperations(String s, String t, int iter1, int iter2, int[][] dp) {
        if (iter1 == s.length() && iter2 == t.length()) {
            return 0;
        }
        if (iter1 >= s.length() || iter2 >= t.length()) {
            return -1;
        }
        if (dp[iter1][iter2] != -1) {
            return dp[iter1][iter2];
        }

        if (s.charAt(iter1) == t.charAt(iter2)) {
            int res = findOperations(s, t, iter1 + 1, iter2 + 1, dp);
            return dp[iter1][iter2] = res;
        }

        int remove = findOperations(s, t, iter1 + 1, iter2, dp);
        int replace = findOperations(s, t, iter1 + 1, iter2 + 1, dp);
        int insert = findOperations(s, t, iter1, iter2 + 1, dp);

        ArrayList<Integer> operations = new ArrayList<Integer>();
        if (remove != -1)
            operations.add(remove);
        if (replace != -1)
            operations.add(replace);
        if (insert != -1)
            operations.add(insert);
        if (operations.isEmpty()) {
            return (dp[iter1][iter2] = -1);
        }
        operations.sort(Comparator.comparingInt(Integer::intValue));
        return (dp[iter1][iter2] = operations.get(0) + 1);
    }

    public static void main(String[] args) {
        String s = "geffek";
        String t = "gesekt";
        System.out.println(new MatchStrings().editDistance(s, t));
    }
}
