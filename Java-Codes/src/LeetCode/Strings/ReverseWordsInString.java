package LeetCode.Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75 />
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 */

public class ReverseWordsInString {

    public String reverseWords(String s) {
        List<String> stringSplit = Arrays.asList(s.split(" "));
        Collections.reverse(stringSplit);

        return stringSplit.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining(" "));
    }

}
