package LeetCode.Arrays;

import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> symbolToValue = Map.of('I', 1, 'V', 5, 'X', 10, 'L',
                50, 'C', 100, 'D', 500, 'M', 1000);
        int output = 0;

        char[] charArray = s.toCharArray();
        for (int i=0; i<charArray.length; i++) {
            int currValue = symbolToValue.get(charArray[i]);
            int nextValue;
            if (i + 1 != charArray.length && (nextValue = symbolToValue.get(charArray[i + 1]))>currValue) {
                output += nextValue - currValue;
                i++;
            } else {
                output += currValue;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("LC"));
    }
}
