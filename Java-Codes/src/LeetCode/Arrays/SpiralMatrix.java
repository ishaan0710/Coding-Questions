package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    class Pair {
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Pair getNextDirection(Pair current) {
        int x = current.x;
        int y = current.y;

        if (x == 0 && y == 1)
            return new Pair(1,0);
        if (x == 1 && y == 0)
            return new Pair(0, -1);
        if (x == 0 && y == -1)
            return new Pair(-1, 0);
        else return new Pair(0, 1);
    }

    boolean isOutOfBounds(int x, int y, int m, int n) {
        return (x < 0 || y < 0 || x >= m || y >= n);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> spiralOrder = new ArrayList<>();
        int[][] visited = new int[m][n];

        Pair currDirection = new Pair(0,1);
        int x = 0;
        int y = 0;

        for (int i=0; i< m*n; i++) {
            System.out.println(x + " " + y);
            spiralOrder.add(matrix[x][y]);
            visited[x][y] = 1;

            int next_x = x + currDirection.x;
            int next_y = y + currDirection.y;
            if (isOutOfBounds(next_x, next_y, m, n)  || visited[next_x][next_y] == 1) {
                currDirection = getNextDirection(currDirection);
            }
            x = x + currDirection.x;
            y = y + currDirection.y;
        }

        return spiralOrder;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

}
