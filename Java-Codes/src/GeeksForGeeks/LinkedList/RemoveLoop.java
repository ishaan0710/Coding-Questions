package GeeksForGeeks.LinkedList;

/* https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1 */

import java.util.HashSet;
import java.util.Set;

public class RemoveLoop {

    class Node
    {
        int data;
        Node next;
    }

    public static void removeLoop(Node head){
        Set<Node> visitedNodes = new HashSet<>();
        Node curr = head;
        if (curr == null)
            return;
        visitedNodes.add(curr);
        while(curr.next != null) {
            if (visitedNodes.contains(curr.next)) {
                curr.next = null;
                return;
            }
            curr = curr.next;
            visitedNodes.add(curr);
        }
    }

    public static void main(String[] args) {

    }
}
