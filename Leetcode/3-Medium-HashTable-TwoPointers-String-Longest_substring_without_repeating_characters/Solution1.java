/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 22, 2017
 Problem:    longest substring without repeating characters
 Difficulty: Medium
 Notes:

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

// 115 ms 10%
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int curLen = 0, maxLen = 0, index = 0;
        if(s == null || s.length() == 0) return 0;
        char[] sc = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < sc.length; i++) {
            if(set.contains(sc[i])) {
                maxLen = Math.max(curLen,maxLen);
                i = index++;
                set.clear();
                curLen = 0;
            } else {
                set.add(sc[i]);
                curLen++;
            }
        }
        maxLen = Math.max(curLen,maxLen);
        return maxLen;
    }
}