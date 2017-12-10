/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 10, 2017
 Problem:    Remove Invalid Parentheses
 Difficulty: Hard
 Notes:
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

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