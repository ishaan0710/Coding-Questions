package LeetCode.Stack;

import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> openBraceStack = new Stack<>();
        Map<Character, Character> matchingBraces = Map.of('{', '}', '(', ')', '[', ']');

        for (Character ch : s.toCharArray()) {
            if (matchingBraces.keySet().contains(ch)) {
                openBraceStack.push(ch);
                continue;
            }
            if (openBraceStack.isEmpty()) {
                return false;
            }

            Character lastPushedChar = openBraceStack.pop();
            if (matchingBraces.get(lastPushedChar) != ch) {
                return false;
            }
        }
        return openBraceStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("{}"));
    }
}
