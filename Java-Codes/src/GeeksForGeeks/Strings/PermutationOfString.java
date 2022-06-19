package GeeksForGeeks.Strings;

//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Given a string S. The task is to print all permutations of a given string in lexicographically sorted order.
 */

class PermutationOfString {

    public List<String> find_permutation(String input) {
        List<String> output = new ArrayList<>();
        int[] freq = new int[26];
        int flag = 0;
        if (input.charAt(0) >= 'a' && input.charAt(1) <= 'z') {
            input = input.toUpperCase(Locale.ROOT);
            flag = 1;
        }
        for (char c : input.toCharArray()) {
            freq[c-'A']++;
        }
        fillPermutation(0, freq, output, input.length(), new char[input.length()]);
        if (flag == 1) {
            return output.stream().map(String::toLowerCase).collect(Collectors.toList());
        }
        return output;
    }

    private void fillPermutation(int pos, int[] freq, List<String> output, int stringLength, char[] currentString) {
        if (pos == stringLength) {
            output.add(new String(currentString));
            return;
        }
        for (int i=0; i<26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                currentString[pos] = (char) (i + 'A');
                fillPermutation(pos + 1, freq, output, stringLength, currentString);
                freq[i]++;
            }
        }
    }

    public static void main(String[] args) {
        String input = "ABSG";
        PermutationOfString permutationOfString = new PermutationOfString();
        System.out.println(permutationOfString.find_permutation(input));
    }
}
