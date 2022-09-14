package LeetCode.BinarySearch;

/**
 * https://leetcode.com/problems/sqrtx/
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */

public class SqRoot {

    public int mySqrt(int x) {

        int low = 0;
        int high = x;

        return getSqrt(low, high, x);
    }

    private int getSqrt(int low, int high, int x) {
        int mid = low + (high - low) / 2;

        long sqOfMid = (long) mid * mid;
        long sqOfNext = (long) (mid + 1) * (mid + 1);

        if (sqOfMid > x) {
            high = mid - 1;
        } else {
            if (sqOfNext > x) {
                return mid;
            }
            low = mid + 1;
        }
        return getSqrt(low, high, x);
    }

    public static void main(String[] args) {
        SqRoot sqRoot = new SqRoot();
        System.out.println(sqRoot.mySqrt(8));
    }

}
