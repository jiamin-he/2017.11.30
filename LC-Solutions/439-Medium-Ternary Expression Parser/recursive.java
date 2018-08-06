/*
Author: Jiamin
Date: Aug 05, 2018
Problem: Ternary Expression Parser

Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).

Note:

The length of the given string is ≤ 10000.
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.
Example 1:

Input: "T?2:3"

Output: "2"

Explanation: If true, then result is 2; otherwise result is 3.
Example 2:

Input: "F?1:T?4:5"

Output: "4"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"
Example 3:

Input: "T?T?F:5:3"

Output: "F"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"


*/


// 这个方法不work的呀！是个错误的方法！！！！！
// 请务必确保自己的方法work才继续去implement！！！
class Solution {
    public String parseTernary(String expression) {
        if(expression == null || expression.length() < 1) return "";
        if(expression.length() == 1) return expression;
        int questionMark = expression.indexOf("?");
            int colon = expression.indexOf(":"), lastColon = expression.lastIndexOf(":");
        if(expression.charAt(0) == 'T') {
            return parseTernary(expression.substring(questionMark+1, lastColon));
        } else {
            return parseTernary(expression.substring(colon+1, expression.length()));
        }
    }
}

// 如何实现问号和冒号之间的对应关系？ 不是头跟尾对应
// 而是数量上要对应啊！
// 3ms 100%
class Solution {
    public String parseTernary(String expression) {
        if(expression == null || expression.length() < 1) return "";
        if(expression.length() == 1) return expression;
        int count = 0, len = expression.length(), i = 1;
        char[] sc = expression.toCharArray();
        for(; i < len-1; i++) {
            if(sc[i] == '?') count++;
            else if (sc[i] == ':') count--;
            if(count == 0) break;
        }
        if(expression.charAt(0) == 'T') {
            return parseTernary(expression.substring(2, i));
        } else {
            return parseTernary(expression.substring(i+1, expression.length()));
        }
    }
}