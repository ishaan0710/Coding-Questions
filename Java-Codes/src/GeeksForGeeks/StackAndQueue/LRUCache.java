package GeeksForGeeks.StackAndQueue;

import java.util.HashMap;
import java.util.Scanner;

public class LRUCache {
    // Not done Yet
    // -1 -1 -1 -1 -1 -1 -1 -1 -1 94 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 18 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 77 12 -1 -1

    static DoublyLinkedList doublyLinkedList;
    static HashMap<Integer,Integer> map;

    class DoublyLinkedList {
        private final int maxCapacity;
        private int currentCapacity;
        Node head;
        Node tail;

        DoublyLinkedList(int maxCapacity) {
            this.maxCapacity = maxCapacity;
        }

        @Override
        public String toString() {
            if (head == null)
                return "";
            return head.toString();
        }

        class Node {
            int data;
            Node next, prev;

            Node(int data) {
                this.data = data;
            }

            @Override
            public String toString() {
                if (next == null) {
                    return Integer.toString(data);
                }
                return data + " -> " + next;
            }
        }

        public void addNode(int key) {
            Node curr = new Node(key);
            if (currentCapacity == maxCapacity) {
                removeNodeFromHead();
            }
            if (head == null) {
                head = tail = curr;
            } else {
                tail.next = curr;
                curr.prev = tail;
                tail = tail.next;
            }
            currentCapacity++;
        }

        public void removeNode(int key) {
            Node curr = head;
            if (head.data == key) {
                head = head.next;
                if (head != null)
                    head.prev = null;
                currentCapacity--;
                return;
            }
            while (curr != null && curr.data != key) {
                curr = curr.next;
            }
            if (curr != null) {
                curr.prev.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
            }
            currentCapacity--;
        }

        public void removeNodeFromHead() {
            head = head.next;
            head.prev = null;

            currentCapacity--;
        }

    }

    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        doublyLinkedList = new DoublyLinkedList(cap);
        map = new HashMap<>();
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        if (!map.containsKey(key)) {
            return -1;
        }
        doublyLinkedList.removeNode(key);
        doublyLinkedList.addNode(key);
      //  System.out.println("LL - " + doublyLinkedList.toString());
     //   System.out.println("MAP " + map);
        return map.get(key);
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if (map.containsKey(key)) {
            doublyLinkedList.removeNode(key);
        }
        map.put(key, value);

        doublyLinkedList.addNode(key);
       // System.out.println("LL - " + doublyLinkedList.toString());
       // System.out.println("MAP " + map);
        // your code here
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        while(true) {
            System.out.println("Choose operation :");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if (input.startsWith("SET")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                set(x, y);
            } else if (input.startsWith("GET")) {
                int x = sc.nextInt();
                System.out.println(get(x));
            }

        }
    }
}
