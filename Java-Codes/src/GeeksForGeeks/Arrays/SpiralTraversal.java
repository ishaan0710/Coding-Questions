package GeeksForGeeks.Arrays;

import java.util.ArrayList;

class SpiralTraversal {

    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> out = new ArrayList<>();
        int rep = 0;

        while (rep <= (c-1-rep) && rep <= (r-1-rep)) {
            for (int i = rep; i <= (c - 1) - rep; i++) {
                out.add(matrix[rep][i]);
            }
            for (int j = rep + 1; j <= (r - 1) - rep; j++) {
                out.add(matrix[j][c - 1 - rep]);
            }
            for (int i = (c - 1) - rep - 1; i >= rep; i--) {
                out.add(matrix[r - 1 - rep][i]);
            }
            for (int j = (r - 1 - rep - 1); j >= rep + 1; j--) {
                out.add(matrix[j][rep]);
            }
            rep++;
        }

        return out;
    }

    public static void main(String[] args) {
        int[][] matrix = {  {1,   2,  3,  4,  5},
                            {6,   7,  8,  9, 10},
                            {11, 12, 13, 14, 15},
                            {16, 17, 18, 19, 20}};
        System.out.println(spirallyTraverse(matrix, 4,5));
    }
}
