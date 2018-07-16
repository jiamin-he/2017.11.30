/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 05, 2018
 Problem:    Paint House
 Difficulty: Easy
 Notes:

There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
             Minimum cost: 2 + 5 + 3 = 10.
*/

// initialized value is wrong!!!
// thus this one is wrong!!!
class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len][3];
        if(len < 1) return 0;
        dp[0][0] = Math.min(costs[0][1],costs[0][2]);
        dp[0][1] = Math.min(costs[0][0],costs[0][2]);
        dp[0][2] = Math.min(costs[0][0],costs[0][1]);
        
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.min((dp[i-1][1]+costs[i][0]), dp[i-1][2]+costs[i][0]);///red
            dp[i][1] = Math.min((dp[i-1][0]+costs[i][1]), dp[i-1][2]+costs[i][1]);///blue
            dp[i][2] = Math.min((dp[i-1][0]+costs[i][2]), dp[i-1][1]+costs[i][2]);///green
        }
        
        
        return Math.min(Math.min(dp[len-1][0], dp[len-1][1]),dp[len-1][2]);
    }
}

// this one is correct!!!
class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len][3];
        if(len < 1) return 0;
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.min((dp[i-1][1]+costs[i][0]), dp[i-1][2]+costs[i][0]);///red
            dp[i][1] = Math.min((dp[i-1][0]+costs[i][1]), dp[i-1][2]+costs[i][1]);///blue
            dp[i][2] = Math.min((dp[i-1][0]+costs[i][2]), dp[i-1][1]+costs[i][2]);///green
        }
        
        
        return Math.min(Math.min(dp[len-1][0], dp[len-1][1]),dp[len-1][2]);
    }
}