package GeeksForGeeks.LinkedList;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
 *
 * Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
 * (i) a next pointer to the next node,
 * (ii) a bottom pointer to a linked list where this node is head.
 * Each of the sub-linked-list is in sorted order.
 * Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
 *
 *
 * 5 -> 10 -> 19 -> 28
 * |     |     |     |
 * 7     20    22   35
 * |           |     |
 * 8          50    40
 * |                 |
 * 30               45
 *
 * Flatten -  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
 */

public class FlattenLinkedList {

    static class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    static Node flatten(Node root)
    {
        if (root == null) {
            return null;
        }
        Node flattenedListHead = new Node(-1);
        Node flattenedListIter = flattenedListHead;
        Queue<Node> headOfSubList = new PriorityQueue<>(Comparator.comparingInt(o -> o.data));
        Node curr = root;
        while(curr != null) {
            headOfSubList.add(curr);
            curr = curr.next;
        }

        Node headSubList;
        while((headSubList = headOfSubList.poll()) != null) {
            flattenedListIter.bottom = new Node(headSubList.data);
            flattenedListIter = flattenedListIter.bottom;
            if (headSubList.bottom != null) {
                headOfSubList.add(headSubList.bottom);
            }
        }
        return flattenedListHead.bottom;
    }

    public static void main(String[] args) {
        Node testNode = new Node(1);
        testNode.bottom = new Node(5);
        testNode.bottom.bottom = new Node(7);
        testNode.next = new Node(6);
        testNode.next.bottom = new Node(8);
        testNode.next.next = new Node(10);

        Node flattenedNode = flatten(testNode);

        while(flattenedNode != null) {
            System.out.println(flattenedNode.data);
            flattenedNode = flattenedNode.next;
        }
    }
}
