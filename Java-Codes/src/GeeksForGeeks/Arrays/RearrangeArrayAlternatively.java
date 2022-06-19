package GeeksForGeeks.Arrays;

/**
 * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value,
 * second should be min value, third should be second max, fourth should be second min and so on.
 * https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/
 */



/*
    Use multiplication and Modulo trick to store 2 values in a single digit.
    eg. storing 3, 7  -> store 37 with Mod_val = 10 37/10 = 3, 37%10 = 7

    Start from left, encode max_index value in first (arr[0] = (arr[max_ind] % mod) * mod) + arr[0])  max_ind--
    next element requires the smallest one, retrieve by using min_ind (arr[1] = (arr[min_ind] % mod) * mod) + arr[1]) min_ind ++
    next arr[2] = arr[max_ind] %mod mod) + ............

 */
class RearrangeArrayAlternatively {


    public static void rearrange(int arr[], int n)
    {
        int modDivisor = arr[n-1] + 1;
        int min_ind = 0, max_ind = n-1;
        for(int i=0; i<n; i++) {
            if (i % 2 == 0) {
                // even position, need to store largest no as multiplier & curr no as mod
                arr[i] = ((arr[max_ind] % modDivisor) * modDivisor) + arr[i];
                max_ind --;
            } else {
                // odd position, need to store smallest no as multiplier
                arr[i] = ((arr[min_ind] % modDivisor) * modDivisor) + arr[i];
                min_ind ++;
            }
        }
        for(int i=0; i<n; i++) {
            arr[i] = arr[i] / modDivisor;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 7, 9, 11, 13, 15, 19 };
        int n = arr.length;
        rearrange(arr, n);
        for (int j : arr) System.out.print(j + " ");
    }


}
