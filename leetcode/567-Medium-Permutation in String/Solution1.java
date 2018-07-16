/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 01, 2018
 Problem:    Permutation in String
 Difficulty: Medium
 Notes:

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/

// 11ms 99.57%
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for(int i = 0; i < s1.length(); i++){
            map[s1.charAt(i)-'a']++;
        }
        int count = s1.length(); // how many chars are needed.
        int i = 0, j = 0;
        while(j < s2.length()) {
            char c = s2.charAt(j);
            if(map[c-'a'] > 0){
                count--;
            } 
            map[c-'a']--;
            while(count == 0) {
                if(j-i+1 > s1.length()) {
                    char c2 = s2.charAt(i);
                    map[c2-'a']++;
                    if(map[c2-'a']>0) {
                        count++;
                    }
                    i++;
                } else {
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}