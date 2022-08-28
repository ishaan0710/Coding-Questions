package LeetCode.Strings;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations/
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        Stack<Integer> currentPermutations = new Stack<>();
        Set<Integer> availableNums = new HashSet<>();
        Arrays.stream(nums).forEach(availableNums::add);

        permute(0, permutations, availableNums, currentPermutations);
        return permutations;
    }

    private void permute(int pos, List<List<Integer>> permutations, Set<Integer> availableNums, Stack<Integer> currentPermutation) {
        if (availableNums.isEmpty()) {
            List<Integer> permutation = new ArrayList<>(currentPermutation);
            permutations.add(permutation);
            return;
        }

        List<Integer> sequence = new ArrayList<>(availableNums);
        for (Integer integer : sequence) {
            currentPermutation.add(integer);
            availableNums.remove(integer);
            permute(pos + 1, permutations, availableNums, currentPermutation);

            availableNums.add(currentPermutation.pop());
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(nums));
    }

}
