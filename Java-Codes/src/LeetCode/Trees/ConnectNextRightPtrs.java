package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 */

public class ConnectNextRightPtrs {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    void connectNodes(List<Node> levelNodes) {
        if (levelNodes == null || levelNodes.size() == 0) {
            return;
        }

        List<Node> nextLevelNodes = new ArrayList<>();

        for (int i=0; i < levelNodes.size() - 1; i++) {
            levelNodes.get(i).next = levelNodes.get(i+1);
        }
        levelNodes.get(levelNodes.size()-1).next = null;

        for (Node node : levelNodes) {
            if (node.left != null)
                nextLevelNodes.add(node.left);
            if (node.right != null)
                nextLevelNodes.add(node.right);
        }

        connectNodes(nextLevelNodes);
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<Node> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        connectNodes(levelNodes);
        return root;
    }

}
