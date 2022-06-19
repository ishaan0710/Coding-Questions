package GeeksForGeeks.LinkedList;
/*
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list.

https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 */

import java.util.Stack;

public class AddTwoNumbers {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node addTwoLists(Node first, Node second){
        if (first == null && second == null) {
            return null;
        }
        Stack<Integer> numberOne = new Stack<>();
        Stack<Integer> numberTwo = new Stack<>();
        Stack<Integer> result = new Stack<>();
        int carry = 0;

        pushNodeToStack(first, numberOne);
        pushNodeToStack(second, numberTwo);

        while (!numberOne.isEmpty() || !numberTwo.isEmpty()) {
            int a = numberOne.isEmpty() ? 0 : numberOne.pop();
            int b = numberTwo.isEmpty() ? 0 : numberTwo.pop();
            int res = a + b + carry;
            result.push(res % 10);
            carry = res / 10;
        }
        if (carry != 0) {
            result.push(carry);
        }

        Node sumNode;
        sumNode = new Node(result.pop());
        Node sumNodeIter  = sumNode;
        while (!result.isEmpty()) {
            sumNodeIter.next = new Node(result.pop());
            sumNodeIter = sumNode.next;
        }
        return sumNode;
    }

    private static void pushNodeToStack(Node first, Stack<Integer> numberOne) {
        Node curr = first;
        while(curr != null) {
            numberOne.push(curr.data);
            curr = curr.next;
        }
    }


}
