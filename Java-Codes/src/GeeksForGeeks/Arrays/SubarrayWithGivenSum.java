package GeeksForGeeks.Arrays;

// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class SubarrayWithGivenSum {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int currSum = 0;
        int startIndex = 0;
        int endIndex = -1;
        if (currSum == s) {
            return new ArrayList<>();
        }
        for (int i=0 ; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum == s) {
                endIndex = i;
                break;
            }
            if (currSum > s) {
                while (currSum > s) {
                    currSum -= arr[startIndex];
                    startIndex++;
                }
                if (currSum == s) {
                    endIndex = i;
                    break;
                }
            }
        }
        if (endIndex == -1) {
            return new ArrayList<>(Arrays.asList(-1));
        }
        return new ArrayList<>(Arrays.asList(startIndex + 1, endIndex + 1));
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int N = 10, S = 15;
        System.out.println(subarraySum(arr, N, S));
    }
}
