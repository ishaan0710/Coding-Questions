package LeetCode.Strings;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 */

public class GroupAnagrams {

    Map<String, List<String>> anagramGroupMap;

    String sortCharacters(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        for(Character ch : charArray) {
            sb.append(ch);
        }
        return sb.toString();
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        anagramGroupMap = new HashMap<>();

        for (String str : strs) {
            String sortedChars = sortCharacters(str);
            if (anagramGroupMap.containsKey(sortedChars)) {
                List<String> anagramGroup = anagramGroupMap.get(sortedChars);
                anagramGroup.add(str);
            } else {
                List<String> anagramGroup = new ArrayList<>(List.of(str));
                anagramGroupMap.put(sortedChars, anagramGroup);
            }
        }
        return new ArrayList<>(anagramGroupMap.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(str));
    }


}
