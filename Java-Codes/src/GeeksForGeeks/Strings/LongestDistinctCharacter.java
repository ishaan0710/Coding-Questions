package GeeksForGeeks.Strings;

// Given a string S, find length of the longest substring with all distinct characters.
//https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctCharacter {

    static int longestSubstrDistinctChars(String S){
        if (S.length() <= 1)
            return S.length();

        Map<Character, Integer> occurenceMap = new HashMap<>();
        int maxLength = 0;
        int startOfSeq = 0;

        for (int i = 0; i<S.length(); i++) {
            if (occurenceMap.containsKey(S.charAt(i))) {
                System.out.println("Key found in map");
                int j;
                for (j=startOfSeq; S.charAt(j) != S.charAt(i); j++) {
                    occurenceMap.remove(S.charAt(j));
                }
                startOfSeq = j+1;
                System.out.println("start of seq " + startOfSeq);
            } else {
                occurenceMap.put(S.charAt(i), i);
                maxLength = Math.max(maxLength, i - startOfSeq + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LongestDistinctCharacter.longestSubstrDistinctChars("aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv"));
    }



}
