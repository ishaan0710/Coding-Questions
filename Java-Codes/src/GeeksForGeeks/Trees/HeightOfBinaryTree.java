package GeeksForGeeks.Trees;

public class HeightOfBinaryTree {

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

    int height(Node node)
    {
        if (node == null)
            return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

}
