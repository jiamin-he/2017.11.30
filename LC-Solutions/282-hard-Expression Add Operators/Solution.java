/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 25, 2018
 Problem:    Expression Add Operators
 Difficulty: Hard
 Notes:

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
*/

// 要很细心！！！
// time: N * 3^N (StringBuilder also takes N --> N^2 * 3^N)
// space: all of the possible expressions in the result set 
// space: N^2 * 3^N ??? [why]
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        char[] nc = num.toCharArray();
        dfs(nc, res, new StringBuilder(), target, 0, 0, 0);
        return res;
        
    }
    
    public void dfs (char[] nc, List<String> res, StringBuilder sb, int target, long curRes, int index, long prevValue) {
        if(index == nc.length) {
            if(curRes == target)
                res.add(sb.toString());
        } else {
            long curVal = 0;
            for(int i = index; i < nc.length; i++){
                curVal = curVal * 10 + (nc[i] - '0');
                String temp = Long.toString(curVal);
                if(index == 0) {
                    StringBuilder sb2 = new StringBuilder(sb.toString()).append(temp);
                    dfs(nc, res, sb2, target, curVal, i + 1, curVal);
                } else {
                    StringBuilder sbPlus = new StringBuilder(sb.toString()).append('+').append(temp);
                    dfs(nc, res, sbPlus, target, curRes + curVal, i + 1, curVal);
                    
                    StringBuilder sbMinus = new StringBuilder(sb.toString()).append('-').append(temp);
                    dfs(nc, res, sbMinus, target, curRes - curVal, i + 1, -curVal);
                    
                    StringBuilder sbMul = new StringBuilder(sb.toString()).append('*').append(temp);
                    dfs(nc, res, sbMul, target, curRes - prevValue + (curVal * prevValue), i + 1, (curVal * prevValue));
                }
                if(nc[index] == '0') {
                    break;
                }
            }
        }
    }
}