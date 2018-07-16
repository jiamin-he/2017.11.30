/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 24, 2017
 Problem:    Palindromic Substrings
 Difficulty: Medium
 Notes:
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.

*/

class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int sum = 0;

        char[] sc = s.toCharArray();
        for( int i = len-1; i>= 0; i--) {
            dp[i][i] = 1;
            sum += 1;
            for(int j = i+1; j < len; j++) {
                if(sc[i] == sc[j]) {
                    if(j-i < 2) dp[i][j] = 1;
                    else dp[i][j] = dp[i+1][j-1];
                    sum += dp[i][j];
                }
            }
        }
        return sum;
    }
}

