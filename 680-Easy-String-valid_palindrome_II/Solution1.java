/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 28, 2017
 Problem:    Valid Palindrome II
 Difficulty: easy
 Notes:

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.



*/
class Solution {
    public boolean validPalindrome(String s) {
        int length = s.length();
        boolean change = true;
        for(int start = 0, end = length-1; start < end; start++,end--){
            if(s.charAt(start) != s.charAt(end)){
                if(!change) return false;
                else if(s.charAt(start+1) != s.charAt(end) &&
                  s.charAt(start) != s.charAt(end-1)) 
                    return false;
                else if(s.charAt(start+1) != s.charAt(end)){
                    end--;
                    change = false;    
                }
                else if(s.charAt(start) != s.charAt(end-1)){
                    start++;
                    change = false;    
                }   
            }
        }
        return true;
    }
}
