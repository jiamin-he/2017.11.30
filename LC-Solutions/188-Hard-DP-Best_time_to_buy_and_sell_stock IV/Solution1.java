/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 17, 2017
 Problem:    Best Time to Buy and Sell Stock IV
 Difficulty: Hard
 Notes:

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/

class Solution1 {
    public int maxProfit(int k, int[] prices) {
        int tempMax = 0;
        int length = prices.length;
        if (length <=1) return tempMax;
        if (k >= length / 2) {
            for (int i = 1; i < prices.length ; i++ ) 
                if(prices[i-1] < prices[i]) tempMax += (prices[i] - prices[i-1]);
            return tempMax;
           }   
        int[][] profit = new int[k + 1][length];
        // 被初始化为0
        // for (int i = 0; i < k + 1; i++ ) {
        //     for (int j = 0; j < prices.length ; j++ ) {
        //         System.out.println(profit[i][j]);
        //     }
        // }

        for (int i = 1; i <= k ; i++ ) {
            tempMax = -prices[0];
            for (int j = 1; j < length ; j++) {
                profit[i][j] = Math.max(profit[i][j-1], tempMax + prices[j]);
                tempMax = Math.max(tempMax, profit[i-1][j-1] - prices[j]);
            }
        }
        return profit[k][length - 1];
    }

    // better understanding, the same as above
    public int maxProfit(int k, int[] prices) {
        int buy = 0;
        int length = prices.length;
        if (length <=1) return buy;
        if (k >= length / 2) {
            for (int i = 1; i < prices.length ; i++ ) 
                if(prices[i-1] < prices[i]) buy += (prices[i] - prices[i-1]);
            return buy;
           }   
        int[][] sell = new int[k + 1][length];
        // 被初始化为0
        // for (int i = 0; i < k + 1; i++ ) {
        //     for (int j = 0; j < prices.length ; j++ ) {
        //         System.out.println(profit[i][j]);
        //     }
        // }

        for (int i = 1; i <= k ; i++ ) {
            buy = -prices[0];
            for (int j = 1; j < length ; j++) {
                sell[i][j] = Math.max(sell[i][j-1], buy + prices[j]);
                buy = Math.max(buy, sell[i-1][j-1] - prices[j]);
            }
        }
        return sell[k][length - 1];
    }


    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        int k = 4;
        Solution1 s1 = new Solution1();
        System.out.println(s1.maxProfit(2, price));
    }
}
