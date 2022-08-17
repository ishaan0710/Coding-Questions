package LeetCode.Strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }
        for (int i=0; i<s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
