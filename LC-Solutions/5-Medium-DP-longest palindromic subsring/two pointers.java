/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 24, 2017
 Problem:    Longest Palindromic Substring
 Difficulty: Medium
 Notes:
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

*/

// 10ms 99%
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        char[] sc = s.toCharArray();
        int[] param = new int[2]; //param[0]: maxLen, param[1]:leftPos
        for(int i = 0; i < len; i++) {
            i = update(i,param,sc); // 把i赋值过去这一步很重要 节省了很多时间
        }
        return s.substring(param[1],param[0]+param[1]);
    }
    public int update(int i, int[] param, char[] sc) {
        int l = i, r = i;
        while(r<sc.length -1 && sc[r] == sc[r+1]) r++;
        int temp=r;
        while(l > 0  && r< sc.length -1 && sc[l-1] == sc[r+1]) {
            l--; r++;
        }
        if(r-l+1 > param[0]) {
            param[0] = r-l+1;   
            param[1] = l;
        }
        return temp;
    }
}

//17ms 81%
class Solution {
    private int low, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len<2) return s;
        for(int i=0; i<len-1; i++){
            expandPalindrome(s,i, i);//odd
            expandPalindrome(s, i, i+1);//even
        }
        return s.substring(low, low+maxLen);
    }
    private void expandPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if(maxLen<right-left-1){
            low = left+1;
            maxLen = right-left-1;
        }
    }
}