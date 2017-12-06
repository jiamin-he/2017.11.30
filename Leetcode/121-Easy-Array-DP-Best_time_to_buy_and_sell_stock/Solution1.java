/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 17, 2017
 Problem:    Best Time to Buy and Sell Stock
 Difficulty: Easy
 Notes:

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.

*/

class Solution1 {
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;
        int sumOfDiff = 0, maxDiff = 0;
        for (int i = 1; i < prices.length ; i++ ) {
            sumOfDiff = Math.max(0, sumOfDiff += prices[i]-prices[i-1]);
            maxDiff = Math.max(sumOfDiff, maxDiff);
        }
        return maxDiff;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length ; i++) {
            if(prices[i] < min) min = prices[i];
            else maxProfit = Math.max(maxProfit,prices[i] - min);
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        if (prices.length == 0) return 0;
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        for (int i : prices) {
            buy1 = Math.max(buy1, -i);
            sell1 = Math.max(buy1+i, sell1);
        }
        return sell1;
    }

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        Solution1 s1 = new Solution1();
        System.out.println(s1.maxProfit1(price));
        System.out.println(s1.maxProfit2(price));
        System.out.println(s1.maxProfit3(price));
    }
}
