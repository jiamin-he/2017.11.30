/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 03, 2017
 Problem:    minimum window substring
 Difficulty: hard
 Notes:

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.




*/

// 7ms 73%

// (July 7th 2018 re-run this code again.) 4ms 99%
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length()) return "";
        int[] map = new int[256];
        for(char c: t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while(end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1]>0) counter--;
            map[c1]--;
            end++;
            while(counter == 0) {
                if(minLen > end-start) {
                    minLen = end-start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if(map[c2] > 0) counter++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE? "":s.substring(minStart, minStart+minLen);
    }
}


// Sep 24 2018 review
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i = 0; i < tc.length; i++) {
            map[tc[i]]++;
        }
        int left = 0, count = tc.length, res = Integer.MAX_VALUE, resLeft = 0;
        for(int i = 0; i < sc.length; i++) {
            if(map[sc[i]] > 0) {
                count--;
            }
            map[sc[i]]--;
            while(count == 0) {
                if(i - left + 1 < res) {
                    res = i - left + 1;
                    resLeft = left;
                }
                map[sc[left]]++;
                if(map[sc[left]] > 0) {
                    count++;
                }
                left++;
            }
        }
        return res == Integer.MAX_VALUE? "" : s.substring(resLeft, resLeft + res);
    }
}