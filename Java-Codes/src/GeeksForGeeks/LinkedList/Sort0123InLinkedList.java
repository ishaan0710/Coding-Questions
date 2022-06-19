package GeeksForGeeks.LinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only.
 * The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
 * https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
 */

public class Sort0123InLinkedList {

    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }

        @Override
        public String toString() {

            return next == null ? Integer.toString(data) : data + " -> " + next;
        }
    }
    static Node segregate(Node head)
    {
        Node zeroes = new Node(-1);
        Node ones = new Node(-1);
        Node twos = new Node(-2);

        Node zero_t = zeroes;
        Node one_t = ones;
        Node two_t = twos;

        Node curr = head;
        while (curr != null) {
            switch (curr.data) {
                case 0 -> {
                    zero_t.next = curr;
                    zero_t = zero_t.next;
                }
                case  1 -> {
                    one_t.next = curr;
                    one_t = one_t.next;
                }
                case  2 -> {
                    two_t.next = curr;
                    two_t = two_t.next;
                }
            }
            curr = curr.next;
        }
        Node sorted = null;
        if (zeroes.next != null) {
            sorted = zeroes.next;
            zero_t = null;
        }
        return sorted;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(0, 1, 1, 1, 1, 2);
        Node head = null;
        Node curr = null;
        for (int val : input) {
            if (head == null) {
                head = new Node(val);
                curr = head;
            } else {
                curr.next = new Node(val);
                curr = curr.next;
            }
        }
        System.out.println(segregate(head));
    }

}
