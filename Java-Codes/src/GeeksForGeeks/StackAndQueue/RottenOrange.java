package GeeksForGeeks.StackAndQueue;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1
 *
 * Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
 * 0 : Empty cell
 * 1 : Cells have fresh oranges
 * 2 : Cells have rotten oranges
 *
 * We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.
 *
 */
public class RottenOrange {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first + "," + second;
        }
    }

    private boolean areOrangesRotten(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int orangesRotting(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        Set<Pair> currentVisit = new HashSet<>();
        Set<Pair> nextVisit = new HashSet<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    currentVisit.add(new Pair(i, j));
                }
            }
        }

        int minuteCount = 0;
        while (!areOrangesRotten(grid) && !currentVisit.isEmpty()) {
            System.out.println("current Rotten " + currentVisit);

            System.out.println("---------");
            printGrid(grid);
            System.out.println("---------");
            for (Pair rotten : currentVisit) {
                int x = rotten.first;
                int y = rotten.second;
                // [i-1,j], [i+1,j], [i,j-1], [i,j+1]
                if (x > 0) {
                    if (grid[x - 1][y] == 1) {
                        grid[x - 1][y] = 2;
                        nextVisit.add(new Pair(x - 1, y));
                    }
                }
                if (x + 1 < m) {
                    if (grid[x + 1][y] == 1) {
                        grid[x + 1][y] = 2;
                        nextVisit.add(new Pair(x + 1, y));
                    }
                }
                if (y > 0) {
                    if (grid[x][y-1] == 1) {
                        grid[x][y - 1] = 2;
                        nextVisit.add(new Pair(x, y - 1));
                    }
                }
                if (y + 1 < n) {
                    if (grid[x][y+1] == 1) {
                        grid[x][y + 1] = 2;
                        nextVisit.add(new Pair(x, y + 1));
                    }
                }
            }
            currentVisit = nextVisit;
            nextVisit = new HashSet<>();
            minuteCount++;
        }
        if (!areOrangesRotten(grid)) {
            return -1;
        }
        return minuteCount;
    }

    private void printGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(new RottenOrange().orangesRotting(grid));

    }

}
