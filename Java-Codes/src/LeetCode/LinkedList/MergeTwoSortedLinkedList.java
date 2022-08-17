package LeetCode.LinkedList;

import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */

public class MergeTwoSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(-1);
        ListNode listIter = mergedList;
        ListNode iter1 = list1, iter2 = list2;

        while (iter1 != null && iter2 != null) {
            if (iter1.val < iter2.val) {
                listIter.next = new ListNode(iter1.val);
                iter1 = iter1.next;
            } else {
                listIter.next = new ListNode(iter2.val);
                iter2 = iter2.next;
            }
            listIter = listIter.next;
        }

        while (iter1 != null) {
            listIter.next = new ListNode(iter1.val);
            iter1 = iter1.next;
            listIter = listIter.next;
        }
        while (iter2 != null) {
            listIter.next = new ListNode(iter2.val);
            iter2 = iter2.next;
            listIter = listIter.next;
        }
        return mergedList.next;
    }

}
