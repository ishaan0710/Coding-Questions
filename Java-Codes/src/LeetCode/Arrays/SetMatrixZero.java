package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
*  Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 */

public class SetMatrixZero {

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void setZeroes(int x, int y, int[][] matrix) {
        for (int i=0; i<matrix[0].length; i++) {
            matrix[x][i] = 0;
        }
        for (int i=0; i< matrix.length; i++) {
            matrix[i][y] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
       List<Pair> zeroes = new ArrayList<>();

       for (int i=0; i<matrix.length; i++) {
           for (int j=0; j<matrix[0].length; j++) {
               if (matrix[i][j] == 0) {
                   zeroes.add(new Pair(i, j));
               }
           }
       }

       for (Pair pair : zeroes) {
           setZeroes(pair.x, pair.y, matrix);
       }
    }
}
