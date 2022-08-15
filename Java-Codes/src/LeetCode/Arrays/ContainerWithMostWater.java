package LeetCode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        int l = 0;
        int r = n-1;
        while (l<r) {
            int currArea = (r-l) * Math.min(height[l], height[r]);
            maxArea = Math.max(currArea, maxArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,3,7,5,6,8,4};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }
}
