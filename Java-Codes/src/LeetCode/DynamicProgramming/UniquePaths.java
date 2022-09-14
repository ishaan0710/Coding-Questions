package LeetCode.DynamicProgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
 */

public class UniquePaths {

    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for (int i=0; i<m ;i++)
            Arrays.fill(dp[i], -1);

        return getUniquePath(0, 0, m, n, dp);

    }

    private int getUniquePath(int x, int y, int m, int n, int[][] dp) {
        if (x >= m)
            return 0;
        if (y >= n)
            return 0;
        if (x == m -1 && y == n-1)
            return 1;
        if (dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = getUniquePath(x + 1, y, m, n, dp) + getUniquePath(x, y + 1, m, n, dp);
        return dp[x][y];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(1, 1));
    }


}
