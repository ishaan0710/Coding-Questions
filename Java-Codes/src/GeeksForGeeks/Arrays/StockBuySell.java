package GeeksForGeeks.Arrays;

// https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1#

import java.util.ArrayList;

/**
 *
 * The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
 */

class StockBuySell {

    ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> stockPurchase = new ArrayList<>();

        int iter = 0;
        while (iter < n) {
            ArrayList<Integer> individualPurchase = new ArrayList<>();
            iter = findLocalMinima(A, iter);
            individualPurchase.add(iter);
            if (iter == -1)
                break;
            iter = findLocalMaxima(A, iter);
            individualPurchase.add(iter);
            stockPurchase.add(individualPurchase);
            iter ++;
        }
        return stockPurchase;
    }

    private int findLocalMaxima(int[] a, int iter) {
        while (iter + 1 < a.length) {
            if (a[iter] > a[iter + 1]) {
                return iter;
            }
            iter ++;
        }
        return a.length - 1;
    }

    private int findLocalMinima(int[] a, int iter) {
        while (iter + 1 < a.length) {
            if (a[iter] < a[iter + 1]) {
                return iter;
            }
            iter ++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,2,4};
        StockBuySell stockBuySell = new StockBuySell();
        System.out.println(stockBuySell.stockBuySell(arr, arr.length));
    }
}
