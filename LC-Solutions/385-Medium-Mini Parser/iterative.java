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


// 10ms 75%
// O(N) -- one pass 

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        char[] sc = s.toCharArray();
        int temp = 0;
        Deque<NestedInteger> stack = new ArrayDeque<>();
        boolean flag = false;
        boolean positive = true;
        for(int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if(c == '[') {
                stack.push(new NestedInteger());
            }  else if (Character.isDigit(c)) {
                temp = temp*10 + (c-'0');
                flag = true;
            } else if (c == '-'){
                positive = false; 
            } else {
                if(flag && !stack.peek().isInteger()){
                    temp = positive?temp:temp*(-1);
                    NestedInteger ni = new NestedInteger(temp);
                    temp = 0;
                    stack.peek().add(ni);
                    flag = false;
                    positive = true;
                }
                if(c==']' && stack.size() > 1) {
                    NestedInteger pop = stack.pop();
                    stack.peek().add(pop);
                }
            }
        }
        NestedInteger res ;
        if(!stack.isEmpty()) {
            res = stack.peek();
        } else {
            temp = positive?temp:temp*(-1);
            res = new NestedInteger(temp);
        }
        return res;
    }
}