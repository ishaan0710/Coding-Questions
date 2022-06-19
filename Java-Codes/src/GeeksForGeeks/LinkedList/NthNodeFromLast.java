package GeeksForGeeks.LinkedList;

// https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1

public class NthNodeFromLast {

    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
        Node curr = head;
        for (int i=0; i<n-1; i++) {
            if (curr == null)
                return -1;
            curr = curr.next;
        }
        if (curr == null) {
            return -1;
        }
        Node nthNodeFromLast = head;
        while (curr.next != null) {
            curr = curr.next;
            nthNodeFromLast = nthNodeFromLast.next;
        }
        return nthNodeFromLast.data;
    }

    public static void main(String[] args) {

    }

}
