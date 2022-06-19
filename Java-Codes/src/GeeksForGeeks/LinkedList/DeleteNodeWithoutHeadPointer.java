package GeeksForGeeks.LinkedList;

/**
 * You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head node is not given.
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 */

public class DeleteNodeWithoutHeadPointer {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    class Solution
    {
        void deleteNode(Node del)
        {
            if (del == null || del.next == null) {
                return;
            }
            del.data = del.next.data;
            del.next = del.next.next;
        }
    }
}
