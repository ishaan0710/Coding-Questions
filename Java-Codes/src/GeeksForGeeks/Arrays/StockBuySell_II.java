package GeeksForGeeks.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock.
 * You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */

public class StockBuySell_II {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int profit = 0;

        int buyPrice = prices[0];
        int largestUntilNow = buyPrice;
        for (int i=1; i<n; i++) {
            if (prices[i] < largestUntilNow) {
                profit += (largestUntilNow - buyPrice);
                buyPrice = prices[i];
                largestUntilNow = buyPrice;
            } else {
                largestUntilNow = prices[i];
            }
        }
        profit+= (largestUntilNow - buyPrice);
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        StockBuySell_II buySell = new StockBuySell_II();
        System.out.println(buySell.maxProfit(arr));
    }
}
