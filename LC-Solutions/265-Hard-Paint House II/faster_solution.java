/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 05, 2018
 Problem:    Paint House
 Difficulty: Easy
 Notes:

There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. 
Follow up:
Could you solve it in O(nk) runtime?
*/

// time: O(nk)
// space: O(1)
class Solution {
    public int minCostII(int[][] costs) {
        int len = costs.length;
        if(len < 1) return 0;
        int num = costs[0].length;
        int[][] dp = new int[len][num];
        for(int i = 0; i< num; i++){
            dp[0][i] = costs[0][i];
        }
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j < num; j++){
                int min = Integer.MAX_VALUE;
                for(int z = 0; z < num; z++) {
                    if(z!=j && dp[i-1][z]+costs[i][j] < min) min=dp[i-1][z]+costs[i][j];
                }
                dp[i][j] = min; 
            }
        }
        
        int minRes = Integer.MAX_VALUE;
        for(int i = 0; i < num; i++) {
            if(dp[len-1][i] < minRes) minRes = dp[len-1][i];
        }
        return minRes;
    }
}