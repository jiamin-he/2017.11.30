/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 23, 2017
 Problem:    Evaluate Reverse Polish Notation
 Difficulty: medium
 Notes:
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;
                switch(token) {
                    case "+": c = b + a; break;
                    case "-": c = b - a; break;
                    case "*": c = b * a; break;
                    case "/": c = b / a; break; // 注意a/b 还是 b/a
                }
                stack.push(c);
            } else {
                int temp = Integer.parseInt(token);
                stack.push(temp);
            }
        }
        return stack.peek();
    }
}