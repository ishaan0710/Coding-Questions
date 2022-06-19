package GeeksForGeeks.Strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string without spaces, the task is to remove duplicates from it.
 * https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1
 */

public class RemoveDuplicates {

    String removeDups(String S) {
        Set<Character> hashList = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : S.toCharArray()) {
            if (!hashList.contains(c)) {
                hashList.add(c);
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDups(""));

    }

}
