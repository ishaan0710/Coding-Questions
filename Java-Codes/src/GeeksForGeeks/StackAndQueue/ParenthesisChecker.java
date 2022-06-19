package GeeksForGeeks.StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
 */

public class ParenthesisChecker {

    static boolean ispar(String x)
    {
        ArrayList<Character> startPar = new ArrayList<>(Arrays.asList('{', '(', '['));
        ArrayList<Character> endPar = new ArrayList<>(Arrays.asList('}', ')', ']'));

        Stack<Character> openPar = new Stack<>();
        for (Character ch : x.toCharArray()) {
            if (startPar.contains(ch)) {
                openPar.push(ch);
            } else {
                if (openPar.isEmpty())
                    return false;
                Character tos = openPar.pop();
                if (startPar.indexOf(tos) != endPar.indexOf(ch)) {
                    return false;
                }
            }
        }
        return openPar.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(ispar("(([)])"));
    }

}
