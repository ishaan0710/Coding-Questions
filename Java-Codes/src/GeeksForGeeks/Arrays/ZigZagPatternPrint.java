package GeeksForGeeks.Arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 */

public class ZigZagPatternPrint {

    public String convert(String s, int numRows) {
        int length = s.length();
        char[][] pattern = new char[numRows][length];

        /*
            dir = 0 down
            dir = 1 zip up
         */

        int iter = 0;
        int curr_col = 0;
        int curr_row = 0;
        int dir = 0;

        while (iter < s.length()) {
            if (dir == 0) {
                for (curr_row=0; curr_row < numRows && iter < s.length(); curr_row++) {
                    pattern[curr_row][curr_col] = s.charAt(iter);
                    iter++;
                }
                curr_col++;
                dir = 1;
            } else {
                for (int i=0; i < numRows - 2 && iter < s.length(); i++) {
                    pattern[numRows - 2 - i][curr_col] = s.charAt(iter);
                    curr_col++;
                    iter++;
                }
                dir = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < numRows; row ++) {
            for (int col = 0; col < length; col++) {
                if (Character.isLetter(pattern[row][col]) || Arrays.asList(',', '.').contains(pattern[row][col])) {
                    stringBuilder.append(pattern[row][col]);
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ZigZagPatternPrint zigZagPatternPrint = new ZigZagPatternPrint();
        System.out.println(zigZagPatternPrint.convert("PAYPALISHIRING", 3));
    }

}
