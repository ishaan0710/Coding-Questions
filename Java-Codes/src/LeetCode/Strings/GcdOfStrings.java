package LeetCode.Strings;

/**
 * <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/?source=submission-ac">...</a>
 *
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Alter hack -
 * Algorithm
 *
 * Check if the concatenations of str1 and str2 in different orders are the same.
 *
 * If not, return "".
 * Get the GCD gcdLength of the two lengths of str1 and str2.
 *
 * Return the prefix string with a length of gcdLength of either str1 or str2 as the answer.
 */

public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        String longerString = str1.length() > str2.length() ? str1 : str2;
        String shorterString = str1.equals(longerString) ? str2 : str1;

        for (int i=shorterString.length(); i>0; i--) {
            String substring = shorterString.substring(0, i);

            if (isDivisable(longerString, substring) && isDivisable(shorterString, substring)) {
                return substring;
            }
        }
        return "";
    }

    public boolean isDivisable(String divident, String divisor) {
        int dividentLength = divident.length();
        int divisorLength = divisor.length();

        if (dividentLength < divisorLength) {
            return false;
        }
        if (dividentLength % divisorLength != 0) {
            return false;
        }
        StringBuilder concatString = new StringBuilder();
        for (int i=0; i<dividentLength/divisorLength; i++) {
            concatString.append(divisor);
        }
        return divident.equals(concatString.toString());
    }


    // Faster approach - if concatenation of str1 & str2 is equal in both orders, return gcd of lengths.
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public String gcdOfStringsFaster(String str1, String str2) {
        // Check if they have non-zero GCD string.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Get the GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

}
