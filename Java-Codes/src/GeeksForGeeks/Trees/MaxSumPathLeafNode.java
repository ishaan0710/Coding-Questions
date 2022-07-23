package GeeksForGeeks.Trees;

/**
 * https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
 *
 * Given a binary tree in which each node element contains a number. Find the maximum possible path sum from one leaf node to another leaf node.
 */

public class MaxSumPathLeafNode {

    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    class NodeWithPath extends Node {

        NodeWithPath(int item) {
            super(item);
        }
    }

    int maxPathSum(Node root)
    {
        return 0;// code here
    }
}
