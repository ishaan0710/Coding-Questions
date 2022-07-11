package GeeksForGeeks.Trees;

/**
 * https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
 *
 * Given a binary tree, find if it is height balanced or not.
 * A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree
 */

public class BalancedTreeCheck {

    class Node
    {
        int data;
        Node left,right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    boolean isBalanced = true;

    private int getHeight(Node root) {
        if (root == null)
            return 0;
        int leftHeight = 1 + getHeight(root.left);
        int rightHeight = 1 + getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            isBalanced = false;
        return Math.max(leftHeight, rightHeight);
    }


    boolean isBalanced(Node root)
    {
        getHeight(root);
        return isBalanced;
    }
}
