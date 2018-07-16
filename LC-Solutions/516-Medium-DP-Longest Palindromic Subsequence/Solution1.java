/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 24, 2017
 Problem:    Longest Palindromic Subsequence
 Difficulty: Medium
 Notes:
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/

// 112 ms 8%
// 去掉注释的那一句是 58ms 56%
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len == 0) return 0;
        char[] sc = s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = 1;
        for (int k = 1; k < len; k++) {
            for (int i = 0, j = i + k; j < len; i++, j++) {
                if (sc[i] != sc[j]) {
                    dp[i][j] =Math.max(dp[i][j-1],dp[i+1][j]);
                } else {
                    //if(k<2) dp[i][j] = 2; // 不用这一句啦 默认值是0呀！
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
            }
        }
        return dp[0][len - 1];
    }
}

// 把两个for循环放到一起写
// 弄清楚for的i一定一定要从 后面开始！！！ （思考填表顺序）就懂了！！
// 42ms 95%
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len == 0) return 0;
        char[] sc = s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = len-1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i+1; j < len; j++) {
                if (sc[i] != sc[j]) {
                    dp[i][j] =Math.max(dp[i][j-1],dp[i+1][j]);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
            }
        }
        return dp[0][len - 1];
    }
}
