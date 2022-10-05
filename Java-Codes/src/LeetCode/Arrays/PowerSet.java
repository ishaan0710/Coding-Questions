package LeetCode.Arrays;

/**
 * https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        getSubsets(subsets, new ArrayList<>(), 0, nums);

        return subsets;
    }

    private void getSubsets(List<List<Integer>> subsets, ArrayList<Integer> currSet, int pos, int[] nums) {
        if (pos == nums.length) {
            subsets.add(List.copyOf(currSet));
            return;
        }

        currSet.add(nums[pos]);
        getSubsets(subsets, currSet, pos + 1, nums);

        currSet.remove(currSet.size() - 1);
        getSubsets(subsets, currSet, pos + 1, nums);
    }

    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();
        int[] nums = {0,1,2};
        System.out.println(powerSet.subsets(nums));
    }
}
