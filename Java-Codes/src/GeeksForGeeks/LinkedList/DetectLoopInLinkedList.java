package GeeksForGeeks.LinkedList;

/**
 * Given a linked list of N nodes. The task is to check if the linked list has a loop. Linked list can contain self loop.
 * https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 */

class DetectLoopInLinkedList {


    static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    public static boolean detectLoop(Node head){
        Node slowPointer;
        Node fastPointer;
        if (head == null || head.next == null) {
            return false;
        }
        slowPointer = head.next;
        fastPointer = head.next.next;
        while(true) {
            if (slowPointer == fastPointer) {
                return true;
            }
            if (slowPointer.next == null || fastPointer.next == null || fastPointer.next.next == null)
                return false;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = one;
        System.out.println(detectLoop(one));
    }
}
