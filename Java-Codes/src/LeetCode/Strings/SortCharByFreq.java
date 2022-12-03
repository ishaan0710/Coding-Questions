package LeetCode.Strings;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 */

public class SortCharByFreq {

    static class CharFreq {
        Character ch;
        Integer freq;

        public CharFreq(Character ch, Integer freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        List<CharFreq> charFreqList = new ArrayList<>();
        Map<Character, CharFreq> charFreqMap = new HashMap<>();

        for (Character ch: s.toCharArray()) {
            if (charFreqMap.containsKey(ch)) {
                CharFreq charFreq = charFreqMap.get(ch);
                charFreq.freq++;
            } else {
                CharFreq charFreq = new CharFreq(ch, 1);
                charFreqList.add(charFreq);
                charFreqMap.put(ch, charFreq);
            }
        }

        charFreqList.sort(Comparator.comparingInt(o -> o.freq));

        Collections.reverse(charFreqList);
        StringBuilder stringBuilder = new StringBuilder();

        for (CharFreq charFreq : charFreqList) {
            stringBuilder.append(String.valueOf(charFreq.ch).repeat(Math.max(0, charFreq.freq)));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SortCharByFreq sortCharByFreq = new SortCharByFreq();
        System.out.println(sortCharByFreq.frequencySort("Aabb"));
    }
}
