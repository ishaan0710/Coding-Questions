package GeeksForGeeks.Trees;


// Optimize memory usage
import java.util.ArrayList;

public class SerializeDeserializeBT {

    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    private void levelOrderTraversal(ArrayList<Node> currLevel, ArrayList<Integer> serialisedTree) {
        boolean breakLoop = false;
        while (!breakLoop) {
            ArrayList<Node> nextLevel = new ArrayList<>();
            breakLoop = true;
            for (Node node : currLevel) {
                if (node == null) {
                    nextLevel.add(null);
                    nextLevel.add(null);
                    serialisedTree.add(Integer.MIN_VALUE);
                } else {
                    breakLoop = false;
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                    serialisedTree.add(node.data);
                }
            }
            currLevel = nextLevel;
        }
    }

    //Function to serialize a tree and return a list containing nodes of tree.
    public void serialize(Node root, ArrayList<Integer> A)
    {
        if (root == null)
            return;
        ArrayList<Node> currLevel = new ArrayList<>();
        currLevel.add(root);
        levelOrderTraversal(currLevel, A);
    }

    //Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        if (A == null || A.isEmpty()) {
            return null;
        }
        ArrayList<Node> currNodes = new ArrayList<>();
        Node root = new Node(A.get(0));
        currNodes.add(root);
        ArrayList<Node> nextLevelNodes;
        int iter = 1;
        boolean breakLoop = false;
        while (!breakLoop) {
            nextLevelNodes = new ArrayList<>();
            breakLoop = true;
            for (Node node : currNodes) {
                if (node == null) {
                    iter += 2;
                    nextLevelNodes.add(null);
                    nextLevelNodes.add(null);
                    continue;
                }
                breakLoop = false;
                node.left = A.get(iter) == Integer.MIN_VALUE ? null : new Node(A.get(iter));
                node.right = A.get(iter + 1) == Integer.MIN_VALUE ? null : new Node(A.get(iter+1));
                iter += 2;
                nextLevelNodes.add(node.left);
                nextLevelNodes.add(node.right);
            }
            currNodes = nextLevelNodes;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left.right = new Node(5);
        root.right.left.right.left = new Node(7);
        ArrayList<Integer> serialize = new ArrayList<>();
        SerializeDeserializeBT serializeDeserializeBT = new SerializeDeserializeBT();
        serializeDeserializeBT.serialize(root, serialize);
        serializeDeserializeBT.deSerialize(serialize);

    }

}
