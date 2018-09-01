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

// 11ms 76%
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] sc = s.toCharArray();
        int result = 0, cur = 0, sign = 1; // 1 is +, -1 is -.
        for(int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if(c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                cur = 0;
            } else if (c == ')') {
                result += sign * cur;
                result *= stack.pop();
                result += stack.pop();
                sign = 1;
                cur = 0;
            } else if (c == '+') {
                result += sign * cur;
                cur = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * cur;
                cur = 0;
                sign = -1;
            } else if (c == ' ') {
                continue;
            } else {
                cur = cur*10 + (c-'0');
            }
        }
        if(cur != 0) result += sign * cur;
        return result;
    }
}