package LeetCode.Strings;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (checkVisit(i, j, visited, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVisit(int i, int j, boolean[][] visited, char[][] board, String word, int pos) {
        if (i<0 || j<0 || i >= board.length || j >= board[0].length)
            return false;
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(pos)) {
            return false;
        }
        if (pos == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean found = checkVisit(i+1, j, visited, board, word, pos + 1) ||
                checkVisit(i-1 , j, visited, board, word, pos + 1) ||
                checkVisit(i, j+1, visited, board, word, pos + 1) ||
                checkVisit(i, j-1, visited, board, word, pos + 1);

        visited[i][j] = false;

        return found;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'a', 'a'}};

        System.out.println(wordSearch.exist(board, "aaa"));
    }

}
