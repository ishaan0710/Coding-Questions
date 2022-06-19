package GeeksForGeeks.LinkedList;

public class MiddleElementInLL {

    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    int getMiddle(Node head)
    {
        if (head.next == null)
            return head.data;
        Node slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next == null ? slow.data : slow.next.data;
    }


    public static void main(String[] args) {

    }
}
