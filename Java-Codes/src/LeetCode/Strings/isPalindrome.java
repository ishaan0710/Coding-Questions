package LeetCode.Strings;

import java.util.Locale;

/**
 * https://leetcode.com/problems/valid-palindrome/
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */

public class isPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i=0, j=s.length()-1; i < j; i++, j--) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                j--;
            }
            if (i >= j)
                break;
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
