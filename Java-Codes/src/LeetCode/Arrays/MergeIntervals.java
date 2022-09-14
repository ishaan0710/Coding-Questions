package LeetCode.Arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int[][] mergedIntervals = new int[intervals.length][intervals[0].length];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int iter=0;
        int currHigh = intervals[0][1];
        int currLow = intervals[0][0];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] > currHigh) {
                mergedIntervals[iter][0] = currLow;
                mergedIntervals[iter][1] = currHigh;
                iter++;

                currLow = intervals[i][0];
            }
            currHigh = Math.max(currHigh, intervals[i][1]);
        }
        mergedIntervals[iter][0] = currLow;
        mergedIntervals[iter][1] = currHigh;

        return Arrays.copyOfRange(mergedIntervals, 0, iter + 1);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{8,10},{2,6},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(arr);
    }

}
