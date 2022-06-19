package GeeksForGeeks.StackAndQueue;

import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 *
 * Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
 * Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
 * If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.
 */

public class NextLargestElement {

    public static long[] nextLargerElement(long[] arr, int n)
    {
        if (n == 0) {
            return new long[0];
        }
        Stack<Long> elementsLargerThanCurr = new Stack<>();
        long[] nextGreatest = new long[n];
        nextGreatest[n-1] = -1;
        elementsLargerThanCurr.push(arr[n - 1]);

        for (int i=n-2; i>=0; i--) {
            long currElem = arr[i];
            while(!elementsLargerThanCurr.isEmpty() && elementsLargerThanCurr.peek() < currElem) {
                elementsLargerThanCurr.pop();
            }
            nextGreatest[i] = elementsLargerThanCurr.isEmpty() ? -1 : elementsLargerThanCurr.peek();

            elementsLargerThanCurr.push(currElem);
        }

        return nextGreatest;
    }


    public static void main(String[] args) {

    }


}
