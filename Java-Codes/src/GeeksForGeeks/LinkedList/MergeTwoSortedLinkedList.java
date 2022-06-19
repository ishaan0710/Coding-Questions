package GeeksForGeeks.LinkedList;

/**
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 *
 * Merge both of the list (in-place) and return head of the merged list.
 */

public class MergeTwoSortedLinkedList {

    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node sortedMerge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node sortedLL = new Node(-1);
        Node sortedLLIter = sortedLL;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                sortedLLIter.next = head2;
                head2 = head2.next;
            } else if (head2 == null) {
                sortedLLIter.next = head1;
                head1 = head1.next;
            } else if (head1.data <= head2.data) {
                sortedLLIter.next = head1;
                head1 = head1.next;
            } else {
                sortedLLIter.next = head2;
                head2 = head2.next;
            }
            sortedLLIter = sortedLLIter.next;
        }
        sortedLLIter.next = null;
        return sortedLL.next;
    }

}
