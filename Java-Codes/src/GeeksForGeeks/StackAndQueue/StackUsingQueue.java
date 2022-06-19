package GeeksForGeeks.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1
 *
 * Implement a Stack using two queues q1 and q2.
 */

public class StackUsingQueue {


    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    void push(int a)
    {
        q1.add(a);
    }

    //Function to pop an element from stack using two queues.
    int pop()
    {
        if (q1.isEmpty()) {
            return -1;
        }
        int returnElem = -1;
        while (!q1.isEmpty()) {
            int top = q1.poll();
            if (q1.isEmpty()) {
                returnElem = top;
                break;
            }
            q2.add(top);
        }
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return returnElem;
    }

}
