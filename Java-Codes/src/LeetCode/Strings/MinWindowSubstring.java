package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
 * such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 */

public class MinWindowSubstring {

    private boolean isSubset(Map<Character, Integer> freqMapFind, Map<Character, Integer> currMap) {

        for (Character key : freqMapFind.keySet()) {
            if (currMap.getOrDefault(key, 0) < freqMapFind.get(key))
                return false;
        }
        return true;
    }

    private void incOne(Character ch, Map<Character, Integer> freqMap) {
        if (freqMap.containsKey(ch)) {
            freqMap.put(ch, freqMap.get(ch) + 1);
        } else {
            freqMap.put(ch, 1);
        }
    }

    private void decOne(Character ch, Map<Character, Integer> freqMap) {
        Integer prevFreq = freqMap.getOrDefault(ch, 1);
        if (prevFreq == 1) {
            freqMap.remove(ch);
        } else {
            freqMap.put(ch, prevFreq - 1);
        }
    }


    public String minWindow(String s, String t) {

        Map<Character, Integer> freqMapFind = new HashMap<>();
        Map<Character, Integer> currMap = new HashMap<>();

        for (Character ch : t.toCharArray()) {
            incOne(ch, freqMapFind);
        }

        int minLength = Integer.MAX_VALUE;
        String minSubString = null;

        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            incOne(s.charAt(end), currMap);
            while (isSubset(freqMapFind, currMap)) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minSubString = s.substring(start, end + 1);
                }
                decOne(s.charAt(start), currMap);
                start++;
            }
        }
        return minSubString;
    }

    public static void main(String[] args) {

        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(new MinWindowSubstring().minWindow(s,t));
    }
}
