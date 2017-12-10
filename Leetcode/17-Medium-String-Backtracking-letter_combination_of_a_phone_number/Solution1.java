/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    letter combination of a phone number
 Difficulty: Medium
 Notes:

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
[pic]


Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/



// bfs(queue)
// go through all siblings
// this iterative method is much faster than the backtracking(dfs) one.
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        char[] digit = digits.toCharArray();
        for(int i = 0; i < digits.length(); i++) {
            while(res.peek().length() == i) {
                int x = digit[i]-'0';
                String temp = res.remove();
                for(char s: mapping[x].toCharArray()) {
                    res.add(temp+s);
                }
            }
        }
        return res;
    }
}


//dfs
// use stringbuilder
// 4ms 22%
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0) return res;
        dfs(res, new StringBuilder(), digits.toCharArray(), 0);
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder sb, char[] digits, int pos) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(pos == digits.length) {
            res.add(sb.toString());
            return;
        }
        for(char c: mapping[digits[pos]-'0'].toCharArray()) {
            // without the remove(delete), the stringbuilder here won't work
            // since stringbuilders in java have same object and reference. whereas for string a same refrence exists but a new object is created
            // so when we pass the stringbuilder, it will always use this same stringbuilder, and it will get longer and longer and longer.....
            // but with these two len and setLength,
            sb.append(c);
            dfs(res,sb,digits,pos+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

// if use dfs but string
// you do not need to delete!
// because you have nothing to delete
// it's just pass by value
// do not change the original value of the initial things
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0) return res;
        dfs(res, "", digits.toCharArray(), 0);
        return res;
    }
    
    public void dfs(List<String> res, String s, char[] digits, int pos) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(pos == digits.length) {
            res.add(s);
            return;
        }
        for(char c: mapping[digits[pos]-'0'].toCharArray()) {
            dfs(res,s+c,digits,pos+1);
        }
    }
}
