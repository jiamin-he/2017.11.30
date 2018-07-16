/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 01, 2018
 Problem:    Ugly Number II
 Difficulty: Medium
 Notes:

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/

// 用dp思路写出来的：（actually 几乎跟math的思路完全一样）
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] base = new int[] {2,3,5};
        int[] pointer = new int[3];
        for(int m = 1; m <= n-1; m++) {
            int temp = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int h = 0; h < 3; h++) {
                if(dp[pointer[h]] * base[h] <= temp) {
                    temp = dp[pointer[h]] * base[h];
                    minIndex = h;
                }
            }
            pointer[minIndex]++;
            if(dp[m-1] != temp) {
                dp[m] = temp;
            } else {
                m--;
            }
        }
        return dp[n-1];
    }
}

// 别人的dp思路
public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int m = 1; dp[n - 1] == 0;) {
            int tempt = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            if (tempt == dp[i] * 2) i++;
            else if (tempt == dp[j] * 3) j++;
            else if (tempt == dp[k] * 5) k++;
            if (dp[m - 1] != tempt) dp[m++] = tempt;
        }
        return dp[n - 1];
    }