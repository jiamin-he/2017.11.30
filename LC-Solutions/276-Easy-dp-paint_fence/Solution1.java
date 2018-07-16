/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 07, 2017
 Problem:    paint fence
 Difficulty: Easy
 Notes:

There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.


*/

class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0 ) return 0;
        if(n == 1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k*k;
        for(int i = 2; i < n  ; i++){
            dp[i] = (dp[i-2] * (k-1) )+ (dp[i-1]*(k-1));
        }
        return dp[n-1];
    }
}


class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0 ) return 0;
        if(n == 1) return k;
        int pprev = k;
        int prev = k*k ;
        for(int i = 2; i < n  ; i++){
            int temp = prev;
            prev = (pprev + temp) * (k-1);
            pprev = temp;
        }
        return prev;
    }
}
