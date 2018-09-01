/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 25, 2018
 Problem:    Basic Calculator
 Difficulty: Hard
 Notes:

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

// 3ms 100%
class Solution {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        int[] pos = new int[]{0};
        char[] sc = s.toCharArray();
        return helper(sc, pos);
    }
    
    public int helper(char[] sc, int[] pos) {
        int res = 0, val = 0, sign = 1;
        for(int i = pos[0]; i < sc.length; i++) {
            char c = sc[i];
            if(c == '(') {
                pos[0] = i+1;
                res += sign * helper(sc,pos);
                i=pos[0];
            } else if( c== ')') {
                res += sign*val;
                pos[0] = i;
                return res;
            } else if ( c == '+') {
                res+= sign*val;
                val = 0;
                sign = 1;
            } else if (c == '-') {
                res+= sign*val;
                val = 0;
                sign = -1;
            } else if (c == ' ') {
                continue;
            } else {
                val = val* 10 + (c-'0');
            }
        }
        if(val != 0) res+= sign*val;
        return res;
    }
}