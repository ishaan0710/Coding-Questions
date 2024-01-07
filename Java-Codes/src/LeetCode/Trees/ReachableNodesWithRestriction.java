package LeetCode.Trees;

import java.util.*;

/**
 * https://leetcode.com/problems/reachable-nodes-with-restrictions/
 *
 * There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
 *
 * You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.
 *
 * Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.
 *
 * Note that node 0 will not be a restricted node.
 */

public class ReachableNodesWithRestriction {

    private static class TreeNode {
        int value;
        List<TreeNode> neighbourNodes;
        boolean blocked;

        public TreeNode(int value, boolean blocked) {
            this.value = value;
            neighbourNodes = new ArrayList<>();
            this.blocked = blocked;
        }
    }

    private void addIfNotPresent(int value, Set<Integer> restrictedNodesValues, HashMap<Integer, TreeNode> treeNodeHashMap) {
        if (!treeNodeHashMap.containsKey(value)) {
            TreeNode treeNode = new TreeNode(value, restrictedNodesValues.contains(value));
            treeNodeHashMap.put(value, treeNode);
        }
    }


    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        Set<TreeNode> visitedNodes = new HashSet<>();
        Set<Integer> restrictedNodesValues = new HashSet<>();
        HashMap<Integer, TreeNode> treeNodeHashMap = new HashMap<>();
        int numberOfNodesVisited = 0;

        for (int restrict : restricted) {
            restrictedNodesValues.add(restrict);
        }


        for (int[] edge : edges) {

            addIfNotPresent(edge[0], restrictedNodesValues, treeNodeHashMap);
            addIfNotPresent(edge[1], restrictedNodesValues, treeNodeHashMap);

            TreeNode firstNode = treeNodeHashMap.get(edge[0]);
            TreeNode secondNode = treeNodeHashMap.get(edge[1]);

            firstNode.neighbourNodes.add(secondNode);
            secondNode.neighbourNodes.add(firstNode);
        }


        TreeNode root = treeNodeHashMap.get(0);
        Stack<TreeNode> currVisit = new Stack<>();
        currVisit.add(root);
        while (!currVisit.empty()) {
            numberOfNodesVisited++;
            TreeNode currNode = currVisit.pop();
            visitedNodes.add(currNode);

            currNode.neighbourNodes.stream()
                    .filter(node -> !node.blocked && !visitedNodes.contains(node))
                    .forEach(currVisit::add);
        }
        return numberOfNodesVisited;
    }

    public static void main(String[] args) {
        ReachableNodesWithRestriction reachableNodesWithRestriction = new ReachableNodesWithRestriction();

        int n = 7;
        int[][] edges = {{0,1}, {0,2},{0,5},{0,4},{3,2},{6,5}};
        int[] restricted = {4,2,1};

        System.out.println(reachableNodesWithRestriction.reachableNodes(n, edges, restricted));
    }

}
