package LeetCode.Arrays;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 * HashSet have average query time of O(1).
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {

    public int longestConsecutive(int[] nums) {
        Set<Integer> isPresent = new HashSet<>();
        int maxConsecutive = -1;

        for (int num : nums) {
            isPresent.add(num);
        }

        for (int num : nums) {
            int currConsecutive = 1;
            while (isPresent.contains(num + currConsecutive)) {
                currConsecutive++;
            }
            maxConsecutive = Math.max(currConsecutive, maxConsecutive);
        }

        return maxConsecutive;
    }

}
