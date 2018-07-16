/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 04, 2018
 Problem:    Palindrome Permutation
 Difficulty: Easy
 Notes:

Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true

*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)]++;
        }
        int oddNum = 0;
        for(int i = 0; i < map.length; i++){
            if(map[i]%2!=0) oddNum++;
            if(oddNum > 1) return false;
        }
        return true;
    }
}