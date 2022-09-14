package LeetCode.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 0;

        for (int i=digits.length - 1; i>=0; i--) {
            digits[i] = digits[i] + 1 + carry;
            if (digits[i] == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        int[] plusOne;
        int iter = 0;
        if (carry == 1) {
            plusOne = new int[digits.length + 1];
            plusOne[iter] = 1;
        } else {
            plusOne = new int[digits.length];
        }

        for (int i=0; i<digits.length; i++) {
            plusOne[iter++] = digits[i];
        }
        return plusOne;
    }

    public static void main(String[] args) {

    }
}
