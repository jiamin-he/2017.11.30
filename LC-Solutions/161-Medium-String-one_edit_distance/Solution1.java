/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 07, 2017
 Problem:    One Edit Distance
 Difficulty: Medium
 Notes:
Given two strings S and T, determine if they are both one edit distance apart.

*/

// 1ms 
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()) {
            return modify(s.toCharArray(), t.toCharArray());
        }
        return s.length() > t.length()? 
            delete(s.toCharArray(), t.toCharArray()): 
            delete(t.toCharArray(), s.toCharArray());
    }
    
    public boolean delete (char[] s, char[] t) {
        if(s.length != t.length + 1) return false;
        int i = 0, j = 0;
        for(; j < t.length; i++,j++) {
            if(s[i] != t[j]) break;
        }
        for(i = i+1;j<t.length; i++, j++) {
            if(s[i] != t[j]) {
                return false;
            }
        }
        return true;
    }
    
    public boolean modify(char[] s, char[] t) {
        int count = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] != t[i]) {
                count++;
            }
        }
        return count == 1;
    }
}