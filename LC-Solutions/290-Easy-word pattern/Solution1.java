/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 01, 2018
 Problem:    word pattern
 Difficulty: Easy
 Notes:

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] map = new String[26];
        Set<String> set = new HashSet<>();
        String[] strs = str.split(" ");
        int length = pattern.length();
        if(length != strs.length) return false;
        for(int i = 0; i < length; i++){
            String word = strs[i];
            char c= pattern.charAt(i);
            if(map[c-'a'] == null) {
                map[c-'a'] = word;
                if(set.contains(word)) return false;
                set.add(word);
            }
            if(!map[c-'a'].equals(word)) return false;
        }
        return true;
    }
}