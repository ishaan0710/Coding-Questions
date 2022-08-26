package LeetCode.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 */

public class ValidateSudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i=0; i<n; i++) {
            if (!validateRow(board, i)) {
                return false;
            }
        }
        for (int i=0; i<n; i++) {
            if (!validateColumn(board, i)) {
                return false;
            }
        }
        for (int i=0; i<n; i+=3) {
            for (int j=0; j<n; j+=3) {
                if (!validateGrid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateGrid(char[][] board, int x, int y) {
        Set<Character> appearedChar = new HashSet<>();
        for (int i=x; i<x+3; i++) {
            for (int j=y; j<y+3; j++) {
                char num = board[i][j];
                if (num != '.' && appearedChar.contains(num)) {
                    return false;
                }
                appearedChar.add(num);
            }
        }
        return true;
    }

    private boolean validateColumn(char[][] board, int column) {
        Set<Character> appearedChar = new HashSet<>();
        int n = board.length;
        for (char[] chars : board) {
            char num = chars[column];
            if (num != '.' && appearedChar.contains(num)) {
                return false;
            }
            appearedChar.add(num);
        }
        return true;
    }

    private boolean validateRow(char[][] board, int row) {
        Set<Character> appearedChar = new HashSet<>();
        int n = board.length;
        for (int i=0; i<n; i++) {
            char num = board[row][i];
            if (num != '.' && appearedChar.contains(num)) {
                return false;
            }
            appearedChar.add(num);
        }
        return true;
    }
}
