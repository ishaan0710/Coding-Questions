package GeeksForGeeks.Trees;

/**
 * https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
 *
 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
 * The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL.
 * The order of nodes in DLL must be same as Inorder of the given Binary Tree.
 * The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.
 *
 * -- This solution is not in-place --
 */

public class BinaryTreeToDLL {

    static class Node
    {
        Node left, right;
        int data;

        Node(int d)
        {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            if (this.right == null)
                return Integer.toString(this.data);
            return this.data + " -> " + this.right;
        }
    }

    Node inorder(Node root, Node prevDllNode, Node dllTempHead) {
        if (root == null)
            return prevDllNode;
        prevDllNode = inorder(root.left, prevDllNode, dllTempHead);

        prevDllNode.right = new Node(root.data);
        prevDllNode.right.left = prevDllNode;
        prevDllNode = prevDllNode.right;

        prevDllNode = inorder(root.right, prevDllNode, dllTempHead);
        return prevDllNode;
    }

    Node bToDLL(Node root)
    {
        Node dllTempHead = new Node(-1);

        inorder(root, dllTempHead, dllTempHead);
        dllTempHead.right.left = null;
        return dllTempHead.right;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(12);
        head.left.left = new Node(25);
        head.left.right = new Node(30);
        head.right = new Node(15);
        head.right.left = new Node(36);

        Node dll = new BinaryTreeToDLL().bToDLL(head);
        System.out.println(dll);
    }
}
