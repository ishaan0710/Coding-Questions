package LeetCode.Stack;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

public class LetterCombinationOfPhoneNumbers {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, List<Character>> digitToCharMap = Map.of(
                2, Arrays.asList('a', 'b', 'c'),
                3, Arrays.asList('d','e','f'),
                4, Arrays.asList('g', 'h', 'i'),
                5, Arrays.asList('j','k','l'),
                6, Arrays.asList('m', 'n', 'o'),
                7, Arrays.asList('p', 'q', 'r', 's'),
                8, Arrays.asList('t', 'u', 'v'),
                9, Arrays.asList('w','x','y', 'z')
        );

        List<String> combinations = new ArrayList<>();
        getCombinations(digits, 0, digitToCharMap, combinations, new Stack<>());
        if (combinations.isEmpty()) {
            return List.of("");
        }
        return combinations;
    }

    private void getCombinations(String digits, int iter, Map<Integer, List<Character>> digitToCharMap, List<String> combinations, Stack<Character> currString) {
        if (iter == digits.length()) {
            StringBuilder sb = new StringBuilder();
            currString.forEach(sb::append);
            combinations.add(sb.toString());
            return;
        }
        Integer digit = digits.charAt(iter) - '0';
        for (Character ch : digitToCharMap.get(digit)) {
            currString.add(ch);
            getCombinations(digits, iter + 1, digitToCharMap, combinations, currString);
            currString.pop();
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumbers letterCombinationOfPhoneNumbers = new LetterCombinationOfPhoneNumbers();
        System.out.println(letterCombinationOfPhoneNumbers.letterCombinations("23"));
    }
}
