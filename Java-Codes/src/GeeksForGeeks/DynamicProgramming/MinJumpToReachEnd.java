package GeeksForGeeks.DynamicProgramming;


/**
 * Given an array of N integers arr[] where each element represents the max length of the jump that can be made forward from that element.
 * Find the minimum number of jumps to reach the end of the array (starting from the first element).
 * If an element is 0, then you cannot move through that element.
 */

public class MinJumpToReachEnd {

    static int minJumps(int[] arr) {
        int n = arr.length;
        int jumps = 0;
        int high = n;
        int bestJump;
        while(true) {
            bestJump = -1;
            for (int i=high-1; i>=0; i--) {
                if (high-i <= arr[i]) {
                    bestJump = i;
                }
            }
            if (bestJump == -1) {
                return -1;
            }
            high = bestJump;
            //System.out.println("Jump #" + jumps + " bestJump " + bestJump);
            jumps++;
            if (high == 0) {
                return arr[0] == 0 ? -1 : jumps;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 10, 2, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }

}
