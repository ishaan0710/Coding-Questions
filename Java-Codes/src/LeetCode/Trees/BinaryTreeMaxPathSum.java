package LeetCode.Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */

public class BinaryTreeMaxPathSum {

    static class PathSum {
        int leftPathSum;
        int rightPathSum;
    }

    public int maxPathSum(TreeNode root) {
        Map<TreeNode, PathSum> pathSumMap = new HashMap<>();
        calculateChildPathSums(root, pathSumMap);

        int maxPathSum = Integer.MIN_VALUE;
        for (TreeNode treeNode : pathSumMap.keySet()) {
            PathSum pathSum = pathSumMap.get(treeNode);
            maxPathSum = Math.max(maxPathSum, treeNode.val + pathSum.leftPathSum + pathSum.rightPathSum);
        }

        return maxPathSum;
    }

    private void calculateChildPathSums(TreeNode node, Map<TreeNode, PathSum> pathSumMap) {
        if (node == null) {
            return;
        }
        if (pathSumMap.containsKey(node)) {
            return;
        }
        calculateChildPathSums(node.left, pathSumMap);
        calculateChildPathSums(node.right, pathSumMap);

        PathSum pathSum = new PathSum();
        if (node.left == null) {
            pathSum.leftPathSum = 0;
        } else {
            PathSum pathSumLeftChild = pathSumMap.get(node.left);
            pathSum.leftPathSum = node.left.val + Math.max(pathSumLeftChild.leftPathSum, pathSumLeftChild.rightPathSum);
        }

        if (node.right == null) {
            pathSum.rightPathSum = 0;
        } else {
            PathSum pathSumRightChild = pathSumMap.get(node.right);
            pathSum.rightPathSum = node.right.val + Math.max(pathSumRightChild.leftPathSum, pathSumRightChild.rightPathSum);
        }
        if (pathSum.leftPathSum < 0) {
            pathSum.leftPathSum = 0;
        }
        if (pathSum.rightPathSum < 0) {
            pathSum.rightPathSum = 0;
        }
        pathSumMap.put(node, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(-10);
        root.left.right = new TreeNode(-20);
        root.right.left = new TreeNode(-30);
        root.right.right = new TreeNode(-40);

        BinaryTreeMaxPathSum binaryTreeMaxPathSum = new BinaryTreeMaxPathSum();
        int x = binaryTreeMaxPathSum.maxPathSum(root);
        System.out.println(x);
    }

}
