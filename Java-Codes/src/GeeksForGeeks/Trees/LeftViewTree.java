package GeeksForGeeks.Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LeftViewTree {

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

    private void inorderTravel(Node curr, Set<Integer> heightVisited, ArrayList<Integer> leftView, int currHeight) {
        if (curr == null)
            return;
        if (!heightVisited.contains(currHeight)) {
            leftView.add(curr.data);
            heightVisited.add(currHeight);
        }
        inorderTravel(curr.left, heightVisited, leftView, currHeight + 1);
        inorderTravel(curr.right, heightVisited, leftView, currHeight + 1);
    }

    ArrayList<Integer> leftView(Node root)
    {
        Set<Integer> heightVisited = new HashSet<>();
        ArrayList<Integer> leftView = new ArrayList<>();
        inorderTravel(root, heightVisited, leftView, 0);
        return leftView;
    }

}
