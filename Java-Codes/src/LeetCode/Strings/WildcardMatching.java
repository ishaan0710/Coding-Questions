package LeetCode.Strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wildcard-matching/
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 */

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return match(s, p, 0, 0, dp);
    }

    private boolean match(String s, String p, int iter1, int iter2, int[][] dp) {
        if (iter1 == s.length() && iter2 == p.length()) {
            return true;
        }
        if (iter1 == s.length()) {
            if (p.charAt(iter2) == '*') {
                return match(s, p, iter1, iter2 + 1, dp);
            } else {
                return false;
            }
        }
        if (iter2 == p.length()) {
            return false;
        }
        if (dp[iter1][iter2] != -1) {
            return dp[iter1][iter2] == 1;
        }
        boolean charMatch = s.charAt(iter1) == p.charAt(iter2) || p.charAt(iter2) == '?' || p.charAt(iter2) == '*';
        boolean matchFound;
        if (p.charAt(iter2) == '*') {

            matchFound = match(s, p, iter1 + 1, iter2, dp) || match(s, p, iter1, iter2 + 1, dp);
            dp[iter1][iter2] = matchFound ? 1 : 0;
            return matchFound;
        }
        if (charMatch) {
            matchFound = match(s, p, iter1 + 1, iter2 + 1, dp);
            dp[iter1][iter2] = matchFound ? 1 : 0;
            return matchFound;
        }
        return false;
    }

}
