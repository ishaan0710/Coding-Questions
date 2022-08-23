package LeetCode.BinarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
 * For this problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1, and if the quotient is strictly less than -231, then return -231.
 */

public class DivideTwoInteger {

    static class Pair {

        long quotient;
        long remainder;

        public Pair(long quotient, long remainder) {
            this.quotient = quotient;
            this.remainder = remainder;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "quotient=" + quotient +
                    ", remainder=" + remainder +
                    '}';
        }
    }

    public int divide(int dividend, int divisor) {
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -1 * dividend;
        }
        if (divisor == 1) {
            return dividend;
        }

        // Handle zero divide, out of bounds.
        int sign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? 1 : -1;

        Map<Long, Pair> dp = new HashMap<>();
        Pair pair = binaryDivide(Math.abs((long)dividend), Math.abs((long)divisor), dp);
        System.out.println(pair);
        System.out.println(dp);

        return sign * (int) pair.quotient;
    }

    private Pair binaryDivide(long dividend, long divisor, Map<Long, Pair> dp) {
        if (dividend < divisor) {
            return new Pair(0, dividend);
        }

        if (dp.containsKey(dividend)) {
            return dp.get(dividend);
        }
        long a = dividend >> 1;
        long b = dividend - a;
        Pair l = binaryDivide(a, divisor, dp);
        dp.put(a, l);
        Pair r = binaryDivide(b, divisor, dp);
        dp.put(a, r);

        long totalRemainder;
        long totalQuotient;

        totalQuotient = l.quotient + r.quotient;
        totalRemainder = l.remainder + r.remainder;
        while (totalRemainder >= divisor) {
            totalRemainder -= divisor;
            totalQuotient++;
        }
        Pair ans = new Pair(totalQuotient, totalRemainder);
        dp.put(dividend, ans);
        return ans;
    }

    public static void main(String[] args) {
        DivideTwoInteger divideTwoInteger = new DivideTwoInteger();
        divideTwoInteger.divide(1,-1);
    }
}
