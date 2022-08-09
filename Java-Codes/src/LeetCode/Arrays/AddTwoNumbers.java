package LeetCode.Arrays;

/**
 *
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultHead = new ListNode();
        ListNode iter = resultHead;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carry);
            iter.next = new ListNode(sum % 10);
            iter = iter.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = (l1.val + carry);
            iter.next = new ListNode(sum % 10);
            iter = iter.next;
            carry = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = (l2.val + carry);
            iter.next = new ListNode(sum % 10);
            iter = iter.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        if(carry != 0) {
            iter.next = new ListNode(carry);
        }
        return resultHead.next;
    }
}
