/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 22, 2017
 Problem:    Longest Valid Parentheses
 Difficulty: Hard
 Notes:

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


*/

// 12ms 72%
class Solution {
    public int longestValidParentheses(String s) {
        return Math.max(longestBiDirection(s,true), longestBiDirection(s,false));
    }
    public int longestBiDirection(String s, boolean left){
        if(s.length() < 1) return 0;
        int sum = 0, res = 0;
        char[] sc = s.toCharArray();
        if(left) {
            int start = 0;
            for(int i = 0; i < sc.length; i++) {
                int temp = sc[i]=='('? -1:1;
                sum += temp;
                if(sum == 0) {
                    res = Math.max(res, i-start+1);
                } else if (sum > 0) {
                    sum = 0;
                    start = i+1;
                }
            } 
        } else {
            int start = sc.length-1;
            for(int i = sc.length-1; i >= 0; i--) {
                int temp = sc[i]=='('? 1:-1;
                sum += temp;
                if(sum == 0) {
                    res = Math.max(res, start-i+1);
                } else if (sum > 0) {
                    sum = 0;
                    start = i-1;
                }
            }
        }
        return res;
    }
}