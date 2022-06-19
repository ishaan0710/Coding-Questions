package GeeksForGeeks.Arrays;

class KthSmallestElement {

    private static void heapify(int[] arr, int root) {
        int largest = root;
        int l = 2 * root + 1;
        int r = 2 * root + 2;

        if (l < arr.length && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < arr.length && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest);
        }
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        int n = arr.length;
        for (int i = n/2-1; i>0; i--) {
            heapify(arr, i);
        }
        while(k-- > 0) {
            heapify(arr, 0);
          //  arr[0] = arr[i];
        }
        for (int i=1; i<=k; i++)
        {
            heapify(arr, 0);
            arr[0] = arr[n-i];
        }
        return  arr[0];
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,3,4,2};
        System.out.println(kthSmallest(arr, 0, arr.length, 3));
    }

}
