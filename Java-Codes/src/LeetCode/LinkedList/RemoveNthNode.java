package LeetCode.LinkedList;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

public class RemoveNthNode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            if (next == null) {
                return Integer.toString(val);
            }
            return val + " -> " + next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode nLeadNode = curr;

        for (int i=0; i<n; i++) {
            nLeadNode = nLeadNode.next;
        }
        if (nLeadNode == null) {
            return head.next;
        }

        while(nLeadNode.next != null) {
            nLeadNode = nLeadNode.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode curr = new ListNode(1);
        curr.next = new ListNode(2);
        curr.next.next = new ListNode(3);
        curr.next.next.next = new ListNode(4);
        curr.next.next.next.next = new ListNode(5);
        RemoveNthNode removeNthNode = new RemoveNthNode();
        System.out.println(removeNthNode.removeNthFromEnd(curr, 3));
    }

}
