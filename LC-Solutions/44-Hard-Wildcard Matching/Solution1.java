/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 8, 2018
 Problem:    Wildcard Matching
 Difficulty: Hard
 Notes:
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
*/

// 这个方法不work！！！
// 因为对于*之后来说 有多个选择
// 我这里只取了第一个出现的选择 是不对的！！

//"abefcdgiescdfimde"
//"ab*cd?i*de"
// my output: false
// actually: true

class Solution {
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int scPos = 0;
        boolean prevStar = false;
        for(int i = 0; i < pc.length; i++) {
            char c = pc[i];
            if(c == '*') {
                prevStar = true;
            } else {
                if( c == '?') {
                    if(scPos >= sc.length) {
                        return false;
                    }
                    scPos++;
                } else {
                    if(prevStar) {
                        System.out.println(c + " " + scPos);
						// 就是这里， 其实不应该每次都选第一个出现的！！有多种选择的话应该是要backtracking的！！
                        int pos = s.indexOf(c, scPos);
                        if(pos < 0) return false;
                        scPos = pos+1;
                    } else {
                        if(scPos >= sc.length || c != sc[scPos]) {
                            return false;   
                        }
                        scPos++;
                    }
                    prevStar = false;
                }
            }
        }
        if(!prevStar && scPos < sc.length) {
            return false;
        }
        return true;
    }
}


class Solution {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
    }
}