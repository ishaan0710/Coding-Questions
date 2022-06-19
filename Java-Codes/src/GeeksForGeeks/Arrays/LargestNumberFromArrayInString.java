package GeeksForGeeks.Arrays;

// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1

import java.util.*;

/**
 *  Given a list of non-negative integers, arrange them in such a manner that they form the largest number possible.
 *  The result is going to be very large, hence return the result in the form of a string.
 *  O(N LogN)
 *  Difficulty - 3.5/5
 */

class LargestNumberFromArrayInString {

    String printLargest(String[] arr) {
        Arrays.sort(arr, (s1, s2) -> {
            String s1First = s1.concat(s2);
            String s2First = s2.concat(s1);

            return s2First.compareTo(s1First);
        });
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(arr).forEachOrdered(stringBuilder::append);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String arr[] = {"54", "546", "548", "60", "543"};
        LargestNumberFromArrayInString largestNumFromArray = new LargestNumberFromArrayInString();
        System.out.println(largestNumFromArray.printLargest(arr));

    }

}
