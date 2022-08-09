package LeetCode.Arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqChars = new HashSet<>();
        Queue<Character> currentSubstring = new LinkedList<>();
        int largestSubstringLen = 0;

        if (s.isEmpty())
            return largestSubstringLen;

        for (Character ch : s.toCharArray()) {
            if (uniqChars.contains(ch)) {
                Character topOfQueue;
                while (ch != (topOfQueue = currentSubstring.poll())){
                    uniqChars.remove(topOfQueue);
                }
            }
            uniqChars.add(ch);
            currentSubstring.add(ch);
            largestSubstringLen = Math.max(largestSubstringLen, currentSubstring.size());
        }
        return largestSubstringLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeating().lengthOfLongestSubstring("pwkewop"));
    }
}
