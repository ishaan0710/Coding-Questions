package GeeksForGeeks.Trees;

public class CheckIfTreeEqual {

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    boolean isSubTreeEqual(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        return root1.data == root2.data && isSubTreeEqual(root1.left, root2.left) && isSubTreeEqual(root1.right, root2.right);
    }

    boolean isIdentical(Node root1, Node root2)
    {
        return isSubTreeEqual(root1, root2);
    }

}
