package LeetCode.Arrays;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */

public class ReverseInteger {

    public int reverse(int x) {
        int reversedNum = 0;
        while (x != 0) {
            if ((Integer.MAX_VALUE / 10 < reversedNum) ||
                    (Integer.MIN_VALUE / 10 > reversedNum)) {
                return 0;
            }
            reversedNum *= 10;
            if (x > 0 && Integer.MAX_VALUE - (x%10) < reversedNum || (x<0 && Integer.MIN_VALUE - (x%10) > reversedNum)) {
                return 0;
            }
            reversedNum += x % 10;
            x /= 10;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(2147483647));
    }

}
