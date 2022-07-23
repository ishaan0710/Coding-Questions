package GeeksForGeeks.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int lcs(int x, int y, String s1, String s2)
    {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i=0; i<s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return getLongestCommonSubsequence(0, 0, s1, s2, dp);
    }

    private static int getLongestCommonSubsequence(int iter1, int iter2, String s1, String s2, int[][] dp) {
        if (iter1 >= s1.length() || iter2 >= s2.length()) {
            return 0;
        }
        if (dp[iter1][iter2] != -1) {
            return dp[iter1][iter2];
        }
        if (s1.charAt(iter1) == s2.charAt(iter2)) {
            return (dp[iter1][iter2] = 1 + getLongestCommonSubsequence(iter1 + 1, iter2 + 1, s1, s2, dp));
        }
        return (dp[iter1][iter2] = Math.max(getLongestCommonSubsequence(iter1, iter2 + 1, s1, s2, dp),
                                    getLongestCommonSubsequence(iter1 + 1, iter2, s1, s2, dp)));
    }

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "XTS";
        System.out.println(lcs(s1.length(), s2.length(), s1, s2));
    }

}
