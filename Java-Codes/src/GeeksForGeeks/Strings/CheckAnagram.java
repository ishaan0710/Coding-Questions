package GeeksForGeeks.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 An anagram of a string is another string that contains the same characters, only the order of characters can be different.
 https://practice.geeksforgeeks.org/problems/anagram-1587115620/1
 */

public class CheckAnagram {

    static Map<Character, Integer> getCharacterCount(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            freqMap.put(ch, 1 + freqMap.getOrDefault(ch, 0));
        }
        return freqMap;
    }

    public static boolean isAnagram(String a,String b)
    {
        if (a.length() != b.length())
            return false;
        Map<Character, Integer> freqMapOne = getCharacterCount(a);
        Map<Character, Integer> freqMapTwo = getCharacterCount(b);

        for (Character character : freqMapOne.keySet()) {
            int countOne = freqMapOne.getOrDefault(character, 0);
            int countTwo = freqMapTwo.getOrDefault(character, 0);
            if (countOne != countTwo) {
                return false;
            }
        }
       return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("allergy", "allergic"));
    }
}
