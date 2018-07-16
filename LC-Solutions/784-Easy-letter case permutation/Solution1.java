/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 07, 2018
 Problem:    Letter case permutation
 Difficulty: Easy
 Notes:

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.

*/

// 9ms 96%
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        String copy = S.toLowerCase();
        helper(0, new String(), list, copy);
        return list;
    }
    
    public void helper(int index, String temp, List<String> list, String ori) {
        if(temp.length() == ori.length()) {
            list.add(temp);
        } else {
            char c = ori.charAt(index);
            if(Character.isDigit(c)) {
                helper(index+1, temp+c, list, ori);
            } else {
                helper(index+1, temp+c, list, ori);
                helper(index+1, temp+Character.toUpperCase(c), list, ori);
            }
        }
    }
}