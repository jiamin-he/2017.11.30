/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 16, 2017
 Problem:    Longest Substring with At Most Two Distinct Characters
 Difficulty: Hard
 Notes:
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.


*/
// 1ms 100%
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, end = 0, res = Integer.MIN_VALUE, size = 0;
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        while (end < s.length()){
            if((map[sc[end]] == 0) && size >= 2) {
                if(map[sc[start]] == 1) {
                    size--;
                }
                map[sc[start]]--;
                start++;
                continue;
            } else {
                if(map[sc[end]] == 0) size++;
                map[sc[end]]++;
                res = Math.max(res, (end-start+1));
                end++;
            }
        }
        return res==Integer.MIN_VALUE?0:res;
    }
}