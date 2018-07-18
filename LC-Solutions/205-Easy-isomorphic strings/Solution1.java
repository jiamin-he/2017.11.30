/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 17, 2018
 Problem:    isomorphic strings
 Difficulty: Easy
 Notes:

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/


// remember to go through it from left to right to ensure
// "no two characters can be replaced with the same character."
// 3ms 99%
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!= t.length()) return false;
        return leftToRight(s,t) && leftToRight(t,s);
    }
    public boolean leftToRight(String s, String t) {
        int[] map = new int[256];
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            char cp = t.charAt(i);
            if(map[c] == 0) {
                map[c] = cp;
            } else if(map[c] != cp){
                return false;
            }
        }
        return true;
    }
}