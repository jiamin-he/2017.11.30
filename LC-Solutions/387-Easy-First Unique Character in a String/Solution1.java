/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 26, 2018
 Problem:    First Unique Character in a String
 Difficulty: Easy
 Notes:

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

// time: O(N) + O(26)
// space: 2*O(26)
class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        int[] index = new int[26];
        char[] sc = s.toCharArray();
        for(int i = 0; i < sc.length; i++) {
            if(map[sc[i] - 'a'] == 0) {
                index[sc[i] - 'a'] = i;
            }
            map[sc[i] -'a']++;
        }
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(map[i] == 1) {
                if(index[i] < minIndex) {
                    minIndex = index[i];
                }
            }
        }
        return minIndex == Integer.MAX_VALUE? -1: minIndex;
    }
}

// space: O(1)
// time: indexOf: O(N) --> so O(26N)
class Solution {
    public int firstUniqChar(String s) {
        int minIndex = s.length();
        for( char c ='a'; c<='z';c++){
            if(s.indexOf(c)!=-1 && s.indexOf(c)==s.lastIndexOf(c))
                minIndex=Math.min(minIndex,s.indexOf(c));
        }
        
        return minIndex==s.length()?-1:minIndex;
    }
}