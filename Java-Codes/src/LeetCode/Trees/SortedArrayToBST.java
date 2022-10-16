package LeetCode.Trees;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBst(nums, 0, nums.length);
    }

    private TreeNode buildBst(int[] nums, int start, int end) {
        if (start >= end)
            return null;

        int middle = start + ((end - start) / 2);

        TreeNode curr = new TreeNode(nums[middle]);
        curr.left = buildBst(nums, start, middle);
        curr.right = buildBst(nums, middle + 1, end);
        return curr;
    }
}
