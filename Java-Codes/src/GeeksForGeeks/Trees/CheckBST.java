package GeeksForGeeks.Trees;

/**
 * Given the root of a binary tree. Check whether it is a BST or not.
 */

public class CheckBST {

    private class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root)
    {
        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkNode(Node root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        }
        if (root.data <= lowerBound || root.data >= upperBound) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if (root.left.data < root.data && root.data < root.right.data) {
                return checkNode(root.left, lowerBound, root.data) && checkNode(root.right, root.data, upperBound);
            } else return false;
        } else if (root.left == null) {
            if (root.data < root.right.data) {
                return checkNode(root.right, root.data, upperBound);
            } else
                return false;
        } else {
            if (root.left.data < root.data) {
                return checkNode(root.left, lowerBound, root.data);
            } else
                return false;
        }
    }

    public static void main(String[] args) {

    }


}
