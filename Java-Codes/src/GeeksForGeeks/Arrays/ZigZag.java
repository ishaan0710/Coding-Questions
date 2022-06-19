package GeeksForGeeks.Arrays;

import java.util.Arrays;

class ZigZag {

    void swap(int arr[], int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    void zigZag(int arr[], int n) {
        int increment = 1;

        for (int i=0; i<n-1; i++) {
            if (increment == 1 && arr[i] > arr[i + 1] || increment == -1 && arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
            increment *= -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        ZigZag zigZag = new ZigZag();
        zigZag.zigZag(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
