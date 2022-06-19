package GeeksForGeeks.LinkedList;

/**
 * https://practice.geeksforgeeks.org/problems/implement-queue-using-linked-list/1
 *
 * Implement a Queue using Linked List.
 * A Query Q is of 2 Types
 * (i) 1 x   (a query of this type means  pushing 'x' into the queue)
 * (ii) 2     (a query of this type means to pop an element from the queue and print the poped element)
 */

public class QueueUsingLinkedList {

    static class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int a)
        {
            data = a;
            next = null;
        }
    }

    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a)
    {
        if (rear == null) {
            front = new QueueNode(a);
            rear = front;
            return;
        }
        rear.next = new QueueNode(a);
        rear = rear.next;
    }

    //Function to pop front element from the queue.
    int pop()
    {
        int res = -1;
        if (front != null) {
            res = front.data;
            front = front.next;
        }
        return res;
    }

}
