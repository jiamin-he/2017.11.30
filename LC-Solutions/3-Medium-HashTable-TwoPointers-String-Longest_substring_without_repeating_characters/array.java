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

// 39 ms 98%

// (Jul 5th, 2018) -- 23ms 100% 
// position[c] records the leftmost valid start index for non-repeating current char.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] position=new int[256];
        Arrays.fill(position, -1);
        int res=0;
        for(int left=0, right=0; right<s.length(); right++){
            char c=s.charAt(right);
            if(position[c]>=left) left=position[c]+1;
            res=Math.max(res, right-left+1);
            position[c]=right;
        }
        return res;
    }
}


// Sep 23rd 2018 review
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 1) return 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        char[] sc = s.toCharArray();
        int left = 0, res = 0;
        for(int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if(map[c] < 0) {
                map[c] = i;
            } else {
                res = Math.max(i-left, res);
                left = Math.max(map[c] + 1, left);
                map[c] = i;
            }
        }
        res = Math.max(sc.length - left, res);
        return res;
    }
}