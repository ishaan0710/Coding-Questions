package GeeksForGeeks.LinkedList;

/**
 * https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1
 *
 * Pairwise swap elements of a linked list
 *
 */

public class PairwiseSwapLinkedList {

    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    public Node pairwiseSwap(Node head)
    {
        if (head == null)
            return null;

        Node dummyNode = new Node(-1);
        dummyNode.next = head;

        Node curr = dummyNode;
        Node firstNode;
        Node secondNode;
        while ((firstNode = curr.next) != null) {
            secondNode = firstNode.next;
            if (secondNode == null)
                break;

            Node tmp;
            curr.next = secondNode;
            tmp = secondNode.next;
            secondNode.next = firstNode;
            firstNode.next = tmp;

            curr = firstNode;
        }
        return dummyNode.next;
    }
}
