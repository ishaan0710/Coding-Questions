package LeetCode.Strings;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 */

public class Atoi {

    boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public int myAtoi(String s) {
        int iter = 0;
        int sign = 1;
        int output = 0;
        if (s.isEmpty())
            return output;
        //ignore leading whitespace
        while (iter < s.length() && s.charAt(iter) == ' ') {
            iter++;
        }
        if (s.charAt(iter) == '+' || s.charAt(iter) == '-') {
            sign = s.charAt(iter) == '-' ? -1 : 1;
            iter++;
        }

        while (iter < s.length() && s.charAt(iter) == '0') {
            iter ++;
        }

        while(iter < s.length() && isDigit(s.charAt(iter))) {
            if (sign == 1 && output > Integer.MAX_VALUE/10) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && output > -1 * (Integer.MIN_VALUE/10)) {
                return Integer.MIN_VALUE;
            }

            output *= 10;
            int value = s.charAt(iter) - '0';
            if (sign == 1 && output > Integer.MAX_VALUE - value) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && value != 0 && output > -1 * (Integer.MIN_VALUE + value)) {
                return Integer.MIN_VALUE;
            }

            output += value;
            iter++;
        }
        return sign * output;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("-01324000"));
    }

}
