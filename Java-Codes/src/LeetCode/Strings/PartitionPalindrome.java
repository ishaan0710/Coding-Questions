package LeetCode.Strings;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartitionPalindrome {

    public boolean isPalin[][];

    public List<List<String>> partition(String s) {
        fillPalin(s);

        List<List<String>> partitions = new ArrayList<>();

        getPartitions(0, 0, s, partitions, new ArrayList<>());

        return partitions;
    }

    private void getPartitions(int start, int end, String s, List<List<String>> partitions, List<String> currPartitions) {
        if (end == s.length())
            return;
        if (end == s.length() - 1) {
            if (!isPalin[start][end])
                return;
            String currPartition = s.substring(start, end + 1);
            currPartitions.add(currPartition);
            partitions.add(new ArrayList<>(currPartitions));
            currPartitions.remove(currPartitions.size() - 1);
            return;
        }
        if (isPalin[start][end]) {
            // Add to partition list
            String currPartition = s.substring(start, end + 1);
            currPartitions.add(currPartition);
            getPartitions(end + 1, end + 1, s, partitions, currPartitions);
            currPartitions.remove(currPartitions.size() - 1);

            // Don't add to partition list
            getPartitions(start, end + 1, s, partitions, currPartitions);
        } else {
            getPartitions(start, end + 1, s, partitions, currPartitions);
        }
    }

    private void fillPalin(String s) {
        int len = s.length();
        isPalin = new boolean[len][len];

        for (int i=0; i<len; i++) {
            isPalin[i][i] = true;
        }

        for (int currLen = 2; currLen <= len; currLen++) {
            int end;
            for (int start = 0; (end = start + currLen - 1) < len; start++) {
                if (currLen == 2) {
                    isPalin[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    isPalin[start][end] = (s.charAt(start) == s.charAt(end) && isPalin[start + 1][end - 1]);
                }
            }
        }

        for(int i=0; i<s.length(); i++) {
            System.out.println(Arrays.toString(isPalin[i]));
        }
    }

    public static void main(String[] args) {
        String s = "abccda";
        PartitionPalindrome partitionPalindrome = new PartitionPalindrome();
        List<List<String>> partitions = partitionPalindrome.partition(s);

        for (List<String> partitionList : partitions) {
            System.out.println(partitionList);
        }
    }
}
