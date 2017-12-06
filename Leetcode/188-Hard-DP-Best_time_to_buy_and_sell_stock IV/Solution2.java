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

class Solution2 {
    public int maxProfit(int k, int[] prices) {
        int tempMax = 0;
        int length = prices.length;
        if (length <=1) return tempMax;
        if (k >= length / 2) {
            for (int i = 1; i < prices.length ; i++ ) 
                if(prices[i-1] < prices[i]) tempMax += (prices[i] - prices[i-1]);
            return tempMax;
           }   
        int[] buy = new int[k+1];
        for (int i = 0; i < k+1 ; i++ ) {
            buy[i] = Integer.MIN_VALUE;
        }
        int[] sell = new int[k+1];
        for (int i : prices) {
            for ( int j = 1; j <= k ; j++) {
                buy[j] = Math.max(buy[j], sell[j-1] - i);
                sell[j] = Math.max(sell[j], buy[j] + i);
            }
        }
        return sell[k];
    }

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        int k = 4;
        Solution2 s1 = new Solution2();
        System.out.println(s1.maxProfit(2, price));
    }
}
