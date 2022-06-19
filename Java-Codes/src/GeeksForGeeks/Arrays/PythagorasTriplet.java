package GeeksForGeeks.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

// note - Instead of searching using findLowerBound, we can also use Meet in the Middle Approach to find elements with
// b^2 + c^2 = a^2 by fixing a.
//https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/


class PythagorasTriplet {

    static int findLowerBound(int[] arr, int start, long sqOfSmallSide) {
        int end = arr.length - 1;
        while(start != end) {
            int mid = (start + end) >> 1;
            if (square(arr[mid]) < sqOfSmallSide) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start == arr.length - 1) {
            return -1;
        }
        return start;
    }

    static boolean checkTriplet(int[] arr, int n) {
        Arrays.sort(arr);
        for (int a=0; a<n-2; a++) {
            int c = a+2;
            for (int b=a+1; b<n-1; b++) {
                long sqOfSmallSide = square(arr[a]) + square(arr[b]);
                c = Math.max(c, b+1);
                int lowerBound = findLowerBound(arr, c, sqOfSmallSide);
                if (lowerBound == -1) {
                    break;
                }
                c = lowerBound;
                if (square(arr[c]) == square(arr[a]) + square(arr[b])) {
                    return true;
                }
            }
        }
        return false;
    }

    static long square(int i) {
        return (long) i*i;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6};
        System.out.println(checkTriplet(arr, arr.length));
       // System.out.println(findLowerBound(arr, 4, 25));
    }
}
