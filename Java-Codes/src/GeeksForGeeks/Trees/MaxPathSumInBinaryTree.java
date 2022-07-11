package GeeksForGeeks.Trees;

import java.util.*;

public class MaxPathSumInBinaryTree {

    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    int maxPathSum(Node root)
    {
        Map<Node, List<Integer>> nodeChildMaxSums = new HashMap<>();

        fillMaxPathSum(root, nodeChildMaxSums);
        int maxPath = Integer.MIN_VALUE;

        for (Node node : nodeChildMaxSums.keySet()) {
            if (node.left == null && node.right == null)
                continue;
            int childSum = nodeChildMaxSums.isEmpty() ? 0 : nodeChildMaxSums.get(node).stream().mapToInt(Integer::intValue).sum();
            maxPath = Math.max(maxPath, node.data + childSum);
        }
        return maxPath;
    }

    private void fillMaxPathSum(Node root, Map<Node, List<Integer>> nodeChildMaxSums) {
        if (root == null)
            return;
        if (nodeChildMaxSums.containsKey(root)) {
            return;
        }
        fillMaxPathSum(root.left, nodeChildMaxSums);
        fillMaxPathSum(root.right, nodeChildMaxSums);

        List<Integer> nodeChildMaxSumsList= new ArrayList<>();
        if (root.left != null) {
            int maxSubtreeValue = nodeChildMaxSums.get(root.left).isEmpty() ? 0 : Collections.max(nodeChildMaxSums.get(root.left));
            nodeChildMaxSumsList.add(root.left.data + maxSubtreeValue);
        }
        if (root.right != null) {
            int maxSubtreeValue = nodeChildMaxSums.get(root.right).isEmpty() ? 0 : Collections.max(nodeChildMaxSums.get(root.right));
            nodeChildMaxSumsList.add(root.right.data + maxSubtreeValue);
        }
        nodeChildMaxSums.put(root, nodeChildMaxSumsList);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.right = new Node(6);
        root.right.left = new Node(-5);
        root.right.right = new Node(5);
        MaxPathSumInBinaryTree maxPathSumInBinaryTree = new MaxPathSumInBinaryTree();
        System.out.println(maxPathSumInBinaryTree.maxPathSum(root));
    }

}
