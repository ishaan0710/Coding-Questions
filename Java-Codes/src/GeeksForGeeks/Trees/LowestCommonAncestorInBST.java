package GeeksForGeeks.Trees;

public class LowestCommonAncestorInBST {

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

    private Node preOrder(Node curr, int low, int high) {
        if (curr == null)
            return null;
        if (low <= curr.data && curr.data <= high)
            return curr;
        Node left = preOrder(curr.left, low, high);
        if (left != null)
            return left;
        return preOrder(curr.right, low, high);
    }

    Node LCA(Node root, int n1, int n2)
    {
        int low = Math.min(n1, n2);
        int high = Math.max(n1, n2);
        return preOrder(root, low, high);
    }

    public static void main(String[] args) {

    }

}
