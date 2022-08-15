package LeetCode.Strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 */

public class RegexMatching {

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        boolean match = match(s, p, 0, 0, dp);

        for (int i=0; i<s.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return match;
    }

    private boolean match(String s, String p, int iter1, int iter2, int[][] dp) {
        if (iter1 == s.length() && iter2 == p.length()) {
            return true;
        }
        boolean isNextCharWildcard = iter2 + 1 < p.length() && p.charAt(iter2 + 1) == '*';
        if (iter1 == s.length()) {
            if (isNextCharWildcard) {
                return match(s, p, iter1, iter2 + 2, dp);
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
        boolean charMatch = s.charAt(iter1) == p.charAt(iter2) || p.charAt(iter2) == '.';
        boolean matchFound;
        if (isNextCharWildcard) {
            if (charMatch) {
                matchFound = match(s, p, iter1 + 1, iter2, dp) || match(s, p, iter1, iter2 + 2, dp);
            } else {
                matchFound = match(s, p, iter1, iter2 + 2, dp);
            }
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

    public static void main(String[] args) {
        RegexMatching regexMatching = new RegexMatching();
        System.out.println(regexMatching.isMatch("aabcb"
                                                ,".*a*aa*.*b*.c*.*a*"));
    }
}
