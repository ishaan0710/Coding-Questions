package LeetCode.Arrays;

import java.util.Arrays;

public class TrappingWater {

    public int trap(int[] height) {
        int n = height.length;
        int[] greatestToLeft = new int[n];
        int[] greatestToRight = new int[n];
        greatestToRight[n-1] = -1;
        greatestToLeft[0] = -1;

        for (int i=1; i<n; i++) {
            greatestToLeft[i] = Math.max(height[i-1], greatestToLeft[i-1]);
        }
        for (int i=n-2; i>=0; i--) {
            greatestToRight[i] = Math.max(height[i + 1], greatestToRight[i+1]);
        }
        int waterTrapped = 0;

        for (int i=0; i<n; i++) {
            int contribution = Math.min(greatestToLeft[i], greatestToRight[i]) - height[i];
            if (contribution > 0)
                waterTrapped += contribution;
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingWater trappingWater = new TrappingWater();
        System.out.println(trappingWater.trap(height));
    }

}
