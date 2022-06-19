package GeeksForGeeks.Strings;

//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a String S, reverse the string without reversing its individual words. Words are separated by dots.
 */
class ReverseWordsInString {

    String reverseWords(String input)
    {
        List<String> inputList = Arrays.stream(input.split("\\.")).collect(Collectors.toList());
        Collections.reverse(inputList);
        return String.join(".", inputList);
    }

    public static void main(String[] args) {
        String input = "i.like.this.program.very.much";
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords(input));
    }
}
