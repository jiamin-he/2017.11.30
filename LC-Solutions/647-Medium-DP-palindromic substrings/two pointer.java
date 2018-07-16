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

// 11ms 85%
class Solution {
    public int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;

        int n=s.length();
        int res=0;
        for(int i=0; i<n; i++){
            res+=helper(s, i, i);
            res+=helper(s, i, i+1);
        }
        return res;
    }

    private int helper(String s, int l, int r){
        int res=0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            res++;
        }
        return res;
    }
}