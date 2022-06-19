package GeeksForGeeks.LinkedList;

public class ReverseLinkedList {

    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    private Node reverseNode(Node curr, Node next) {
        if (next == null) {
            return curr;
        }
        Node lastNode = reverseNode(next, next.next);
        next.next = curr;
        return lastNode;
    }

    Node reverseList(Node head)
    {
        Node lastnode = reverseNode(head, head.next);
        head.next = null;
        return lastnode;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node last = new Node(4);
        head.next.next.next = last;
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node lastnode = reverseLinkedList.reverseList(head);
        while (lastnode != null) {
           System.out.println(lastnode.value);
            lastnode = lastnode.next;
        }
    }

}
