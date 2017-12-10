/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 09, 2017
 Problem:    generate parentheses
 Difficulty: medium
 Notes:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

  */

// 4ms 25%
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }
    public void helper(List<String> list, String str, int open, int close, int n) {
        if(str.length() == n*2) {
            list.add(str);
            return;
        }
        if(open < n) {
            helper(list, str+"(", open+1, close, n);
        } 
        if(close < open) {
            helper(list, str+")", open, close+1, n);
        }
    }
}

// 2ms 88%
// 把string 改成char[] 就会快很多～
// 方法仍然类似 只是改成char后不能再用长度来判断
// 上一个方法 open close 表示已经有了几个
// 在这里 表示 还缺少几个
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n < 1) return list;
        char[] candidate = new char[2*n];
        helper(list, candidate,0, n, n);
        return list;
    }
    public void helper(List<String> list, char[] can, int index, int open, int close) {
        if(open + close == 0) {
            list.add(new String(can));
            return;
        }
        if(open > 0) {
            can[index] = '(';
            helper(list, can, index+1, open-1, close);
        } 
        if(close > open) {
            can[index] = ')';
            helper(list, can, index+1, open, close-1);
        }
    }
}

// 用stringbuilder也行 比string 快 比array[] 慢
// 而且记得要手动backtrack！！！
// 2ms 88%
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n < 1) return list;
        helper(list, new StringBuilder() ,0, n, n);
        return list;
    }
    public void helper(List<String> list, StringBuilder sb, int index, int open, int close) {
        if(open + close == 0) {
            list.add(sb.toString());
            return;
        }
        if(open > 0) {
            sb.append('(');
            helper(list, sb, index+1, open-1, close);
            sb.deleteCharAt(sb.length() -1);
        } 
        if(close > open) {
            sb.append(')');
            helper(list, sb, index+1, open, close-1);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
