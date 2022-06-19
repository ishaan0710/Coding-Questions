package GeeksForGeeks.Arrays;

/**
 * Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.
 * https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
 */

class MissingNoInArray {

    static int MissingNumber(int array[], int n) {
        for (int i=0; i< array.length; i++) {
            if (Math.abs(array[i]) == n) {
                continue;
            }
            array[Math.abs(array[i]) - 1] *= -1;
        }

        for (int i=0; i< array.length; i++) {
            if (array[i] > 0) {
                return i+1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int N = 10;
        int A[] = {6,1,2,8,3,4,7,9,5};
        System.out.println(MissingNumber(A, N));
    }

}
