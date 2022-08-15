package LeetCode.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int commonLength = -1;
        boolean match = true;
        while (match) {
            commonLength++;
            if (commonLength == strs[0].length()) {
                commonLength--;
                break;
            }
            char currChar = strs[0].charAt(commonLength);
            for (int i = 1; i < strs.length; i++) {
                if (commonLength == strs[i].length() || strs[i].charAt(commonLength) != currChar) {
                    commonLength --;
                    match = false;
                    break;
                }
            }
        }
        return strs[0].substring(0, commonLength + 1);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {
                "dog","racecar","car"
        };
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
