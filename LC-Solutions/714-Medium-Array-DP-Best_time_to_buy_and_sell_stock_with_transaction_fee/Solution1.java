/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 22, 2017
 Problem:    Best Time to Buy and Sell Stock with transaction fee
 Difficulty: Hard
 Notes:

Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.

*/

class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2 || prices == null ) return 0;
        int buy = -prices[0], sell = 0;
        for (int i = 0; i < prices.length; i++ ) {
            sell = Math.max(buy + prices[i] - fee, sell);
            buy = Math.max(sell - prices[i], buy);
        }
        return sell;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int buy = Integer.MIN_VALUE, sell = 0, prevBuy = 0, prevSell = 0;
        for (int i = 0; i < prices.length ; i++ ) {
            prevBuy = buy;
            buy = Math.max(sell - prices[i] - fee, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + prices[i], prevSell);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4,3,4,55,0,4,4,4,4,44,9};
        Solution1 s1 = new Solution1();
        System.out.println(s1.maxProfit1(price));
    }
}
