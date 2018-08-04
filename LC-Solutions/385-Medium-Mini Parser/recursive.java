/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 21st, 2018
 Problem:    Mini Parser
 Difficulty: Medium
 Notes:

Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.

*/

// 也是one pass
// p 拿来记录当前已经走到哪里了
// 6ms 98%
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        else return deserialize(s, new int[] {1});
    }
    
    private NestedInteger deserialize(String s, int[] p) {
        NestedInteger res = new NestedInteger();
        int num = 0, sign = 1;
        boolean hasNum = false;
        for (; p[0] < s.length(); p[0]++) {
            if (s.charAt(p[0]) == '[') {
                p[0]++;
                res.add(deserialize(s, p));
            } else if (s.charAt(p[0]) == ',') {
                if (hasNum) {
                    res.add(new NestedInteger(sign*num));
                    num = 0; sign = 1; hasNum = false;
                }
            } else if (s.charAt(p[0]) == ']') {
                if (hasNum) res.add(new NestedInteger(sign*num));
                break;
            } else if (s.charAt(p[0]) == '-') {
                sign = -1;
            } else {
                if (!hasNum) hasNum = true;
                num = num*10 + s.charAt(p[0]) - '0';    
            }
        }
        return res;
    }
}