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


//remove current ( or ) and check valid or not.
//valid add to result , invalid add to queue and to be continued
// in the first level, delete any one , so has "length" nodes.
// the flag "found" is to set a flag, control the minimum level is returned.
// time complexity: 
// On the first level, there's only one string which is the input string s, 
// let's say the length of it is n, to check whether it's valid, we need O(n) time. 
// On the second level, we remove one ( or ) from the first level, 
// so there are C(n, n-1) new strings, each of them has n-1 characters, 
// and for each string, we need to check whether it's valid or not, 
// thus the total time complexity on this level is (n-1) x C(n, n-1). 
// Come to the third level, total time complexity is (n-2) x C(n, n-2), so on and so forth...

// T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).

// 96 ms 32%
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null) return res;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            s = q.poll();
            if(isValid(s)) {
                res.add(s);
                found = true;
            }
            if(found) continue;
            char[] temp = s.toCharArray();
            for(int i = 0; i < temp.length; i++) {
                if(temp[i] == '(' || temp[i] == ')' ) {
                    String t = s.substring(0,i) + s.substring(i+1);
                    if(!visited.contains(t)) {
                        q.add(t);
                        visited.add(t);
                    }
                } else {
                    continue;
                }
            }  
        }
        return res;
    }
    
    public boolean isValid(String s) {
        int count = 0; 
        for(char c: s.toCharArray()) {
            if(c == '(') count++;
            if(c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}
