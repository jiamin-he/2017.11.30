/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 22, 2017
 Problem:    Longest Valid Parentheses
 Difficulty: Hard
 Notes:

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


*/

// 23 ms 50%
// T O(n) + S O(n)
class Solution {
    public int longestValidParentheses(String s) {
        char[] sc = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        stack.push(-1); // 因为先push进去了一个 所以后面一旦是空 就说明多出了一个右括号 这是的max值不能被更新 不是有效连续的
                        // 所以当是空的时候 要把当前这个再塞进去
        for(int i = 0; i < sc.length; i++) {
            if(sc[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(!stack.isEmpty()) { // 当非空的时候 peek的是最近的一个没用左括号的值 减一下就得到中间有效段的长度了
                    max = Math.max(max, i-stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }
}