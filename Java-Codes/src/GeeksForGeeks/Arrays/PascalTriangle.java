package GeeksForGeeks.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        pascalTriangle.add(row);
        for (int i=1; i<numRows; i++) {
            row = generatePascalRow(pascalTriangle.get(i-1), i);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }

    private List<Integer> generatePascalRow(List<Integer> prevRow, int rowNo) {
        List<Integer> currRow = new ArrayList<>();

        for (int i=0; i<rowNo; i++) {
            if (i==0 || i == rowNo-1) {
                currRow.add(1);
                continue;
            }
            currRow.add(prevRow.get(i-1) + prevRow.get(i));
        }
        return currRow;
    }

}
