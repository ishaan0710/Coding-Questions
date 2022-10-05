package LeetCode.BinarySearch;

import java.util.*;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 */

public class LargestRectInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nearestSmallerLeft = new int[n];
        int[] nearestSmallerRight = new int[n];

        Stack<Integer> currStack = new Stack<>();

        for (int i=0; i<n; i++) {
            while (!currStack.isEmpty() && heights[currStack.peek()] >= heights[i]) {
                currStack.pop();
            }
            nearestSmallerLeft[i] = currStack.isEmpty() ? -1 : currStack.peek();
            currStack.push(i);
        }

        currStack = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            while(!currStack.isEmpty() && heights[currStack.peek()] >= heights[i]) {
                currStack.pop();
            }
            nearestSmallerRight[i] = currStack.isEmpty() ? n : currStack.peek();
            currStack.push(i);
        }

        int maxArea = -1;
        for (int i=0; i<n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nearestSmallerRight[i] - nearestSmallerLeft[i] - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,6,4,2,5};
        LargestRectInHistogram largestRectInHistogram = new LargestRectInHistogram();
        int x = largestRectInHistogram.largestRectangleArea(arr);
        System.out.println(x);
    }
}
