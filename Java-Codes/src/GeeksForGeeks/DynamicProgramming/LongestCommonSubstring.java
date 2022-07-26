package GeeksForGeeks.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubstring {

    int getLongestCommonSubStr(String S1, String S2, int[][] dp, int iter1, int iter2) {
        if (iter1 >= S1.length() || iter2 >= S2.length())
            return 0;
        if (dp[iter1][iter2] != -1)
            return dp[iter1][iter2];
        if (S1.charAt(iter1) == S2.charAt(iter2)) {
            int iter1_dup = iter1;
            int iter2_dup = iter2;
            int count = 0;
            while (iter1_dup < S1.length() && iter2_dup < S2.length() && S1.charAt(iter1_dup) == S2.charAt(iter2_dup)) {
                iter1_dup++;
                iter2_dup++;
                count++;
            }
            int match = count;

            int skipFirst = getLongestCommonSubStr(S1, S2, dp, iter1 + 1, iter2);
            int skipSecond = getLongestCommonSubStr(S1, S2, dp, iter1, iter2 + 1);
            dp[iter1][iter2] = Math.max(Math.max(match, skipFirst), skipSecond);
        } else {
            int skipFirst = getLongestCommonSubStr(S1, S2, dp, iter1 + 1, iter2);
            int skipSecond = getLongestCommonSubStr(S1, S2, dp, iter1, iter2 + 1);
            dp[iter1][iter2] = Math.max(skipFirst, skipSecond);
        }
        return dp[iter1][iter2];
    }

    int longestCommonSubstr(String S1, String S2, int n, int m){

        int[][] dp = new int[n][m];
        for (int i=0; i<n;i++)
            for(int j=0; j<m; j++)
                dp[i][j] = -1;
        return getLongestCommonSubStr(S1, S2, dp, 0, 0);
    }

}
