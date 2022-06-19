package GeeksForGeeks.StackAndQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
 *
 * Given an input stream of A of n characters consisting only of lower case alphabets.
 * The task is to find the first non repeating character, each time a character is inserted to the stream.
 * If there is no such character then append '#' to the answer.
 */

public class FirstNonRepeatingCharInStream {



    public String FirstNonRepeating(String A)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> hash = new HashMap<>();

        for (Character ch : A.toCharArray()) {
            int hashValue = hash.getOrDefault(ch, 0);
            if (hashValue == 0) {
                hash.put(ch, 1);
                queue.add(ch);
            } else if (hashValue == 1) {
                hash.put(ch, 2);
            }
            while (!queue.isEmpty() && hash.get(queue.peek())== 2) {
                queue.poll();
            }
            stringBuilder.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FirstNonRepeatingCharInStream().FirstNonRepeating("aabc"));
    }


}
