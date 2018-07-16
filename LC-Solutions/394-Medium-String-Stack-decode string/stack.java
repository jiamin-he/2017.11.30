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
        Deque<StringBuilder> stack = new ArrayDeque<>();
        if(s == null || s.length() == 0) return "";
        char[] sc = s.toCharArray();
        int len = s.length();
        for(int i = len-1; i >= 0; ) {
            if(sc[i] == '[') {
                StringBuilder cur = stack.pop();
                if(stack.isEmpty()) stack.push(new StringBuilder());
                StringBuilder peek = stack.peek();
                int digit = 1, multi = 0;
                while(i > 0 && Character.isDigit(sc[--i])) {
                    multi+= (sc[i]-'0')*digit;
                    digit*=10;
                }
                String curStr = cur.toString();
                while(--multi > 0) {
                    cur.append(curStr);
                }
                peek.insert(0,new String(cur));
                if(i==0) break;
            } else if (sc[i] == ']') {
                stack.push(new StringBuilder());
                i--;
            } else {
                if(stack.isEmpty()) stack.push(new StringBuilder());
                StringBuilder cur = stack.peek();
                cur.insert(0,sc[i]);
                i--;
            }
        }
        StringBuilder peek = stack.peek();
        return peek.toString();
    }
}