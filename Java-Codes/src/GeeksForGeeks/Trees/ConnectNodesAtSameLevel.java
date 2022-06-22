package GeeksForGeeks.Trees;

import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
 *
 * Given a binary tree, connect the nodes that are at same level. You'll be given an addition nextRight pointer for the same.
 *
 * Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.
 *        10                       10 ------> NULL
 *       / \                       /      \
 *      3   5       =>     3 ------> 5 --------> NULL
 *     / \     \               /  \           \
 *    4   1   2          4 --> 1 -----> 2 -------> NULL
 *
 *
 */

public class ConnectNodesAtSameLevel {

    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }

    //Function to connect nodes at same level.
    public void connect(Node root)
    {
        ArrayList<Node> currLevelNodes = new ArrayList<>();
        if (root == null)
            return;

        currLevelNodes.add(root);

        while (!currLevelNodes.isEmpty()) {
            ArrayList<Node> nextLevelNodes = new ArrayList<>();
            for (Node node : currLevelNodes) {
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }

            for (int i=0; i<currLevelNodes.size()-1; i++) {
                currLevelNodes.get(i).nextRight = currLevelNodes.get(i+1);
            }
            currLevelNodes = nextLevelNodes;
        }
    }
}
