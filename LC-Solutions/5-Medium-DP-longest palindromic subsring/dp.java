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

// 80 ms 30%
// dp O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        char[] sc = s.toCharArray();
        int maxLen = 1;
        String maxStr = s.substring(0,1);
        boolean[][] pal = new boolean[len][len];
        for(int i = len-1; i>= 0; i--) {
            pal[i][i] = true;
            for (int j = i+1; j < len; j++) {
                if(sc[i] == sc[j]) {
                    if( j - i < 2 || pal[i+1][j-1] == true) {
                        pal[i][j] = true;
                        if(j-i+1 > maxLen) {
                            maxLen = j-i+1;
                            maxStr = s.substring(i,j+1);
                        }      
                    }
                }
            }
        }
        return maxStr;
    }
}