package GeeksForGeeks.StackAndQueue;

import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1
 * Implement a Queue using 2 stacks s1 and s2 .
 * A Query Q is of 2 Types
 * (i) 1 x (a query of this type means  pushing 'x' into the queue)
 * (ii) 2   (a query of this type means to pop element from queue and print the poped element)
 */

public class QueueUsingTwoStacks {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
        s1.push(x);
    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int poppedElem = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return poppedElem;
    }

}
