package LeetCode.Strings;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * Implement strStr().
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

public class StrStr {

    private boolean match(String haystack, String needle, int iter1, int iter2) {
        if (iter2 == needle.length()) {
            return true;
        }
        if (iter1 == haystack.length()) {
            return false;
        }
        if (haystack.charAt(iter1) != needle.charAt(iter2)) {
            return false;
        }
        return match(haystack, needle, iter1 + 1, iter2 + 1);
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        for (int i=0; i<haystack.length(); i++) {
            if (match(haystack, needle, i, 0)) {
                return i;
            }
        }
        return -1;
    }
}
