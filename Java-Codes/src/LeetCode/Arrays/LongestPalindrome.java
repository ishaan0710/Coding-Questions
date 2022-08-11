package LeetCode.Arrays;

import java.util.Arrays;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int[][] isPalindrome = new int[s.length()][s.length()];
        int longestPalindromeStart = 0;
        int longestPalindromeEnd = 0;
        int maxLength = 1;
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(isPalindrome[i], 0);
        }
        for (int i=0; i<s.length(); i++)
            isPalindrome[i][i] = 1;

        for (int len = 2; len <=s.length(); len ++) {
            for (int start = 0; start + len - 1 < s.length(); start++) {
                int end = start + len - 1;
                if (s.charAt(start) != s.charAt(end))
                    continue;
                if (len == 2 || (isPalindrome[start + 1][end - 1] == 1)) {
                    isPalindrome[start][end] = 1;
                    if (len > maxLength) {
                        maxLength = len;
                        longestPalindromeStart = start;
                        longestPalindromeEnd = end;
                    }
                }
            }
        }

        return s.substring(longestPalindromeStart, longestPalindromeEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("ab12ba"));
    }
}
