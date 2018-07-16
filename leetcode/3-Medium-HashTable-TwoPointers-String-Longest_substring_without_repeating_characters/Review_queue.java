/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 05, 2018
 Problem:    longest substring without repeating characters
 Difficulty: Medium
 Notes:

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

// 26 ms 100%
// queue
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList<Character>();
        int longest = 0;
        for(int i = 0; i < s.length(); i++){
            if(!q.contains(s.charAt(i))) {
                q.offer(s.charAt(i));
                if(q.size() > longest) longest = q.size();
            } else {
                while(q.peek() != s.charAt(i)) {
                    q.poll();
                }
                q.poll();
                q.offer(s.charAt(i));
            }
        }
        return longest;
    }
}