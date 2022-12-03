package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list
 * and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 */

public class DeepCopyListWithRandomPtr {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            if (this.next == null) {
                return "Node{" + "val=" + val + ", random=" + random + '}';
            } else {
                return "Node{" + "val=" + val + ", next=" + next + ", random=" + random + "}," + this.next;
            }
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMapping = new HashMap<>();
        Node copyCurr;
        Node copyPrev = null;

        Node curr = head;
        while (curr != null) {
            copyCurr = new Node(curr.val);
            nodeMapping.put(curr, copyCurr);
            if (copyPrev != null) {
                copyPrev.next = copyCurr;
            }
            copyPrev = copyCurr;
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node random = curr.random;
            Node copyNode = nodeMapping.get(curr);
            copyNode.random = nodeMapping.get(random);

            curr = curr.next;
        }
        return nodeMapping.get(head);
    }

    public static void main(String[] args) {

    }

}
