package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */

public class Power {

    Map<Integer, Double> dpMap;

    public double myPow(double x, int n) {
        dpMap = new HashMap<>();
        return calculatePow(x, n);
    }

    private double calculatePow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1/x;
        }
        if (dpMap.containsKey(n)) {
            return dpMap.get(n);
        }
        double pow = calculatePow(x, n/2) * calculatePow(x, n - n/2);
        dpMap.put(n, pow);
        return pow;
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.myPow(2, -2));
    }

}
