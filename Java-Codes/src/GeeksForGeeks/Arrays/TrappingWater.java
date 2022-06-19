package GeeksForGeeks.Arrays;

// https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1

/**
 * Given an array arr[] of N non-negative integers representing the height of blocks.
 * If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.
 */

class TrappingWater {



    static long trappingWater(int arr[], int n) {
        int maxToLeft[] = new int[n];
        int maxToRight[] = new int[n];

        maxToLeft[0] = -1;
        maxToRight[n-1] = -1;
        for (int i=1; i<n; i++) {
            maxToLeft[i] = Math.max(maxToLeft[i-1], arr[i-1]);
            maxToRight[n-i-1] = Math.max(maxToRight[n-i], arr[n-i]);
        }

        long totalWaterTrapped = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] > maxToLeft[i] || arr[i] > maxToRight[i]) {
                continue;
            }
            int waterTrapped = Math.min(maxToLeft[i], maxToRight[i]) - arr[i];
            totalWaterTrapped+= waterTrapped;
        }
        return totalWaterTrapped;
    }

    public static void main(String[] args) {
        int[] arr = {8,10,5,10};
        System.out.println(trappingWater(arr, arr.length));
    }

}
