package LeetCode.Trees;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidNode(root.left, Long.MIN_VALUE, root.val) && isValidNode(root.right, root.val, Long.MAX_VALUE);
    }

    private boolean isValidNode(TreeNode node, long leastValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (node.val <=  leastValue || node.val >= maxValue) {
            return false;
        }

        return isValidNode(node.left, leastValue, node.val) &&
                isValidNode(node.right, node.val, maxValue);
    }
}
