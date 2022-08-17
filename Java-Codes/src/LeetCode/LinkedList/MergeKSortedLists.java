package LeetCode.LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it
 */

public class MergeKSortedLists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode mergedListsHead = new ListNode(-1);
        ListNode iter = mergedListsHead;

        Queue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode poppedNode = priorityQueue.poll();
            iter.next = new ListNode(poppedNode.val);
            iter = iter.next;
            if (poppedNode.next != null) {
                priorityQueue.add(poppedNode.next);
            }
        }
        return mergedListsHead.next;
    }

}
