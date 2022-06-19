package GeeksForGeeks.Trees;

import java.util.*;

public class BottomViewTree {


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


    public ArrayList<Integer> bottomView(Node root)
    {
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        ArrayList<Integer> bottomView = new ArrayList<>();

        preOrder(root, 0, sortedMap);
        Iterator iterator = sortedMap.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            bottomView.add((Integer) entry.getValue());
        }
        return bottomView;
    }

    private void preOrder(Node curr, int pos, SortedMap sortedMap) {
        if (curr == null)
            return;

        sortedMap.put(pos, curr.data);
        preOrder(curr.left, pos - 1, sortedMap);
        preOrder(curr.right, pos + 1, sortedMap);

    }

}
