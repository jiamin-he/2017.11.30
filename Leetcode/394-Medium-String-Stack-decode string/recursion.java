/*
Author: Jiamin
Date: Jan 04, 2017
Problem: Decode String
Difficulty: hard
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/

// 3ms 74%
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int iStart = i; 
                while(Character.isDigit(s.charAt(i))) i++;
                int count = Integer.parseInt(s.substring(iStart,i));
                int paren = 1;
                iStart = ++i;
                while(paren != 0) {
                    if(s.charAt(i) == ']') paren--;
                    else if (s.charAt(i) == '[') paren++;
                    i++;
                }
                i--;
                String subStr = decodeString(s.substring(iStart,i));
                while(count-- > 0) {
                    sb.append(subStr);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}