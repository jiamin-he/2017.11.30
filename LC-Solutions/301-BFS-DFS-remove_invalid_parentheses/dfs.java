/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 10, 2017
 Problem:    Remove Invalid Parentheses
 Difficulty: Hard
 
Example:

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

*/


// from left to right check the close one
// from right to left check the open one.
// 3 ms 67%
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        dfs(res, s, 0,0, new char[] {'(',')'});
        return res;
    }
    public void dfs(List<String> res, String s, int last_i, int last_j, char[] par) {
        for(int counter = 0, i = last_i; i < s.length(); i++) {
            if(s.charAt(i) == par[0]) {
                counter++;
            }
            if(s.charAt(i) == par[1]) {
                counter--;
            }
            if(counter >= 0) continue;
            for(int j = last_j; j <= i; j++) {
                if(s.charAt(j) == par[1] && (j == last_j || s.charAt(j-1) != par[1])) {
                    dfs(res, s.substring(0,j)+s.substring(j+1),i,j,par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0] == '(') {
            dfs(res, reversed, 0 , 0, new char[] {')','('});
        } else {
            res.add(reversed);
        }
    }
}


// Sep 23rd 2018 review
// if only need to return one possible string(minimum change)
class Solution {
    public String removeInvalidParentheses(String s) {
        return dfs(s, 0,0, new char[] {'(',')'});
    }
    public String dfs(String s, int last_i, int last_j, char[] par) {
        boolean control = true;
        for(int counter = 0, i = last_i; i < s.length(); i++) {
            if(s.charAt(i) == par[0]) {
                counter++;
            }
            if(s.charAt(i) == par[1]) {
                counter--;
            }
            if(counter >= 0) continue;
            control = false;
            for(int j = last_j; j <= i; j++) {
                if(s.charAt(j) == par[1] && (j == last_j || s.charAt(j-1) != par[1])) {
                    return dfs(s.substring(0,j)+s.substring(j+1),i,j,par);
                }
            }
        }
        
        if(control) {
            String reversed = new StringBuilder(s).reverse().toString();
            if(par[0] == '(') {
                return dfs(reversed, 0 , 0, new char[] {')','('});
            } else {
                return reversed;
            } 
        }
        
        return "";
    }
}