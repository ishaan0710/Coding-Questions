package LeetCode.Trees;

import LeetCode.Trees.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = 1 + maxDepth(node.left);
        int rightDepth = 1 + maxDepth(node.right);
        return Math.max(leftDepth, rightDepth);
    }
}
