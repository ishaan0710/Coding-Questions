package GeeksForGeeks.LinkedList;

import java.util.Stack;

public class IntersectionPointInYShapedLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }



    //Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2)
    {
        Stack<Node> stackOne = new Stack<>();
        Stack<Node> stackTwo = new Stack<>();
        if (head1 == null || head2 == null) {
            return -1;
        }

        Node curr = head1;
        while(curr != null) {
            stackOne.push(curr);
            curr = curr.next;
        }
        curr = head2;
        while(curr != null) {
            stackTwo.push(curr);
            curr = curr.next;
        }
        int lastCommon = -1;
        while (stackOne.peek() == stackTwo.peek()) {
            lastCommon = stackOne.pop().data;
            stackTwo.pop();
            if (stackOne.isEmpty() || stackTwo.isEmpty())
                break;
        }
        return lastCommon;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);

        head1.next.next.next = head2.next.next.next = new Node(7);
        head1.next.next.next.next = head2.next.next.next.next = new Node(8);
        head1.next.next.next.next.next = head2.next.next.next.next.next = new Node(9);

        IntersectionPointInYShapedLinkedList intersectionPoint = new IntersectionPointInYShapedLinkedList();
        System.out.println(intersectionPoint.intersectPoint(head1, head2));
    }


}
