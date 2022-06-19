package GeeksForGeeks.LinkedList;

public class RotateLinkedList {

    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public Node rotate(Node head, int k) {
        Node curr = head;
        if (k == 0)
            return head;
        for (int i=0; i<k-1; i++) {
            curr = curr.next;
        }
        Node newHead = curr.next;
        if (newHead == null)
            return head;
        curr.next = null;
        curr = newHead;
        while (curr.next != null)
            curr = curr.next;
        curr.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node newHead = new RotateLinkedList().rotate(head, 1);
        while (newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }
}
