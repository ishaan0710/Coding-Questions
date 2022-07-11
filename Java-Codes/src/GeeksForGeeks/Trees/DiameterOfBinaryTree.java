package GeeksForGeeks.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
 *
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.
 * The diagram below shows two trees each with diameter nine, the leaves that form the ends of the longest path are shaded
 * (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 */

public class DiameterOfBinaryTree {

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    int max = 0;

    private int postOrderTraversal(Node curr, Map<Node, Integer> leftSum, Map<Node, Integer> rightSum) {
        if (curr == null)
            return 0;
        int left = postOrderTraversal(curr.left, leftSum, rightSum);
        int right = postOrderTraversal(curr.right, leftSum, rightSum);
        leftSum.put(curr, left);
        rightSum.put(curr, right);
        max = Math.max(1 + left + right, max);
        return 1 + Math.max(left, right);
    }

    int diameter(Node root) {
        Map<Node, Integer> leftSum = new HashMap<>();
        Map<Node, Integer> rightSum = new HashMap<>();
        postOrderTraversal(root, leftSum, rightSum);
        return max;
    }

}
