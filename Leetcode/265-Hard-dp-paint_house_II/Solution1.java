/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 07, 2017
 Problem:    paint house II
 Difficulty: Hard
 Notes:

There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?


*/

// 13 ms 8% 时间复杂度太高 是o nk^2
class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        for(int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < n; i++) {
            for( int j = 0; j < k; j++) {
                for(int m = 0; m < k; m++) {
                    if(j != m) {
                        if(dp[i][j] == 0) dp[i][j] = dp[i-1][m] + costs[i][j];
                        else dp[i][j] = dp[i-1][m] + costs[i][j] < dp[i][j]?   dp[i-1][m] + costs[i][j] : dp[i][j];
                    }
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            if(dp[n-1][i] < minCost) {
                minCost = dp[n-1][i];
            }
        }
        return minCost;
    }
}

// 3ms 77%
// O(nk) Space O(1)
class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = 0, min2 = 0, index1 = 0;
        for(int i = 0; i < n; i++) {
            int newMin1 = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE, newIndex1 = 0;
            for( int j = 0; j < k; j++) {
                int cur = costs[i][j] + (j == index1? min2: min1);
                if(cur < newMin1) {
                    newMin2 = newMin1;
                    newMin1 = cur;
                    newIndex1 = j;
                } else if(cur < newMin2) {
                    newMin2 = cur;
                }
            }
            min1 = newMin1;
            min2 = newMin2;
            index1 = newIndex1;
        }
        return min1;
    }
}
