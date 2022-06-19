package GeeksForGeeks.LinkedList;

/*Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

*/

public class ReverseLinkedListInKGroups {

    static class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }


    public static Node reverse(Node head, int k)
    {
        if (head == null)
            return null;

        int count = 0;
        Node curr = head;
        Node prev = null;
        Node tmp;

        while (count < k && curr != null) {
            tmp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = tmp;
            count ++;
        }

        if (curr != null) {
            head.next = reverse(curr, k);
        }

        return prev;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node last = new Node(4);
        head.next.next.next = last;
        head.next.next.next.next = new Node(5);
        Node newHead = reverse(head, 3);
        Node curr = newHead;
        while (curr != null) {
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }


}
