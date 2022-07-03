package GeeksForGeeks.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
 *
 *          1
 *         / \
 *        2   3
 *       / \  / \
 *      7  6 5  4
 *
 * Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.
 */

public class LevelOrderTraversalInSpiralForm {

    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }


    ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> spiralTraverse = new ArrayList<>();
        if (root == null) {
            return spiralTraverse;
        }
        boolean reverse = true;
        ArrayList<Node> nextLevelNodes = new ArrayList<>();
        nextLevelNodes.add(root);
        while (!nextLevelNodes.isEmpty()) {
            List<Integer> levelOrderTraversal = nextLevelNodes.stream().map(node -> node.data).collect(Collectors.toList());
            if (reverse)
                Collections.reverse(levelOrderTraversal);
            spiralTraverse.addAll(levelOrderTraversal);

            ArrayList<Node> temp = new ArrayList<>();
            for (Node node : nextLevelNodes) {
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
            }
            nextLevelNodes = temp;
            reverse = !reverse;

        }
        return spiralTraverse;
    }
}
