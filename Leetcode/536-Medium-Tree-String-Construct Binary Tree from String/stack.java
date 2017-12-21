/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Construct Binary Tree from String

You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".


*/

// 32ms stack
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        for ( int i=0, j=i; i < s.length(); i++,j=i) {
            if(s.charAt(i) == ')') {
                stack.pop();
                continue;
            }
            if(s.charAt(i) == '(') continue;
            while(i+1 < s.length() && s.charAt(i+1) != '(' && s.charAt(i+1) != ')') i++;
            TreeNode cur = new TreeNode(Integer.parseInt(s.substring(j,i+1)));
            if(!stack.isEmpty()) {
                TreeNode root = stack.peek();
                if(root.left == null) root.left = cur;
                else root.right = cur;
            }
            stack.push(cur);
        }
        return stack.peek();
    }
}