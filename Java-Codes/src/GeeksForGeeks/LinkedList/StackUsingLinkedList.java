package GeeksForGeeks.LinkedList;

public class StackUsingLinkedList {

     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
     StackNode top;


    //Function to push an integer into the stack.
    void push(int a)
    {
        StackNode node = new StackNode(a);
        node.next = top;
        top = node;
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        if (top == null) {
            return -1;
        }
        int res = top.data;
        top = top.next;
        return res;
    }

}
