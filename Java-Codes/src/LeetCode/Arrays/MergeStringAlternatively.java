package LeetCode.Arrays;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 */

public class MergeStringAlternatively {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int iter1 = 0;
        int iter2 = 0;
        int nextTurn = 1;
        while (iter1 < word1.length() && iter2 < word2.length()) {
            if (nextTurn == 1) {
                stringBuilder.append(word1.charAt(iter1));
                iter1++;
                nextTurn = 2;
            } else {
                stringBuilder.append(word2.charAt(iter2));
                iter2++;
                nextTurn = 1;
            }
        }

        while (iter1 < word1.length()) {
            stringBuilder.append(word1.charAt(iter1));
            iter1++;
        }

        while (iter2 < word2.length()) {
            stringBuilder.append(word2.charAt(iter2));
            iter2++;
        }
        return stringBuilder.toString();
    }
}
