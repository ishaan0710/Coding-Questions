package LeetCode.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> parenthesisString = new ArrayList<>();
        List<Character> currentChar = new ArrayList<>();
        currentChar.add('(');
        generateParenthesisWrapper(currentChar, n-1, n, parenthesisString);
        System.out.println(parenthesisString);
        return parenthesisString;
    }

    private void generateParenthesisWrapper(List<Character> chList, int openBracketNum, int closeBracketNum, List<String> parenthesisString) {
        if (openBracketNum < 0 || closeBracketNum < 0)
            return;
        if (closeBracketNum < openBracketNum) {
            return;
        }
        if (openBracketNum == 0 && closeBracketNum == 0) {
            StringBuilder sb = new StringBuilder();
            chList.forEach(sb::append);
            parenthesisString.add(sb.toString());
        }
        chList.add('(');
        generateParenthesisWrapper(chList, openBracketNum - 1, closeBracketNum, parenthesisString);
        chList.remove(chList.size() - 1);
        chList.add(')');
        generateParenthesisWrapper(chList, openBracketNum, closeBracketNum - 1, parenthesisString);
        chList.remove(chList.size() - 1);
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }
}
