package GeeksForGeeks.StackAndQueue;

import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1
 *
 * You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.
 */

public class GetMinElemInStack {

    int minEle;
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minElem = new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
        if (minElem.isEmpty())
            return -1;
        return minElem.peek();
    }

    /*returns poped element from stack*/
    int pop()
    {

        if (stack.isEmpty())
            return -1;
        int poppedElem = stack.pop();
        if (poppedElem == minElem.peek()) {
            minElem.pop();
        }
        return poppedElem;
    }

    /*push element x into the stack*/
    void push(int x)
    {
        stack.push(x);

        if (minElem.isEmpty() || x <= minElem.peek()) {
            minElem.push(x);
        }
    }

}
