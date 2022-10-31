package LeetCode.Arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */

public class SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] cannotCapture = new boolean[m][n];

        for (int i=0; i<n; i++) {
            if (board[0][i] == 'O' && !cannotCapture[0][i]) {
                markCannotCapture(0, i, board, cannotCapture);
            }
            if (board[m-1][i] == 'O' && !cannotCapture[m-1][i]) {
                markCannotCapture(m-1, i, board, cannotCapture);
            }
        }

        for (int i=0; i<m; i++) {
            if (board[i][0] == 'O' && !cannotCapture[i][0]) {
                markCannotCapture(i, 0, board, cannotCapture);
            }
            if (board[i][n-1] == 'O' && !cannotCapture[i][n - 1]) {
                markCannotCapture(i, n-1, board, cannotCapture);
            }
        }

        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (board[i][j] == 'O' && !cannotCapture[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void markCannotCapture(int m, int n, char[][] board, boolean[][] cannotCapture) {
        if (m >= board.length || n >= board[0].length || m < 0 || n < 0)
            return;
        if (board[m][n] == 'X')
            return;
        if (cannotCapture[m][n])
            return;
        cannotCapture[m][n] = true;
        markCannotCapture(m + 1, n, board, cannotCapture);
        markCannotCapture(m - 1, n, board, cannotCapture);
        markCannotCapture(m, n + 1, board, cannotCapture);
        markCannotCapture(m, n - 1, board, cannotCapture);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'O','X','X'},
                {'X','O','X'},
                {'X','O','X'}
        };
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);

        for (int i=0; i<board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }
}
