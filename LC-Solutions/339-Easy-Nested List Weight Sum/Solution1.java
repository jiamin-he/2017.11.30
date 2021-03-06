/*
Author: Jiamin
Date: Aug 04, 2018
Problem: Nested List Weight Sum

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 10 
Explanation: Four 1's at depth 2, one 2 at depth 1.
Example 2:

Input: [1,[4,[6]]]
Output: 27 
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.

*/

// 2ms 100%
// recursively 

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
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList,1);
    }
    public int helper(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for(NestedInteger entry: nestedList){
            if(entry.isInteger()){
                sum += entry.getInteger()*level;
            } else {
                sum += helper(entry.getList(), level+1);
            }
        }
        return sum;
    }
}


class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        Queue<NestedInteger> q = new LinkedList<NestedInteger>();
        for(NestedInteger list : nestedList){
            q.offer(list);
        }
        int depth = 0;
        int sum = 0;
        while(!q.isEmpty()) {
            depth ++;
            int l = q.size();
            for (int i = 0; i < l; i++) {
                NestedInteger curr = q.poll();
                if(curr.isInteger()) {
                    sum += curr.getInteger() * depth;
                }
                else {
                    for (NestedInteger nestint : curr.getList()){
                         q.offer(nestint);
                    }
                   
                }
                
            }
        }
        return sum;
    }
}