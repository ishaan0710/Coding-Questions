package LeetCode.Trees;

import LeetCode.Trees.SymmetricTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrders = new ArrayList<>();
        if (root == null) {
            return levelOrders;
        }
        List<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(root);
        getLevelOrders(currLevel, levelOrders);
        return levelOrders;
    }

    private void getLevelOrders(List<TreeNode> currLevelNodes, List<List<Integer>> levelOrders) {
        if (currLevelNodes == null || currLevelNodes.isEmpty()) {
            return;
        }
        List<Integer> currLevel = new ArrayList<>();
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        for (TreeNode node : currLevelNodes) {
            if (node == null)
                continue;
            currLevel.add(node.val);
            nextLevelNodes.add(node.left);
            nextLevelNodes.add(node.right);
        }
        if (!currLevel.isEmpty())
            levelOrders.add(currLevel);
        getLevelOrders(nextLevelNodes, levelOrders);
    }

}
