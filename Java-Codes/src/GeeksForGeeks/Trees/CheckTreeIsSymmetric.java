package GeeksForGeeks.Trees;

/**
 * https://practice.geeksforgeeks.org/problems/symmetric-tree/1
 *
 * Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.
 */

public class CheckTreeIsSymmetric {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public static boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        System.out.println("left :" + left.data + "right: " + right.data);
        return (left.data == right.data) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static boolean isSymmetric(Node root)
    {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(1);
        head.right = new Node(1);
        head.left.left = new Node(1);
        head.left.left.left = new Node(1);
        System.out.println(isSymmetric(head));
    }

}
