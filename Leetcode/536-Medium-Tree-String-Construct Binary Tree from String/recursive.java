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


// 35ms 56% 
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
        int leftParen = s.indexOf("(");
        String val = (leftParen == -1? s: s.substring(0,leftParen));
        TreeNode root = new TreeNode(Integer.parseInt(val));
        if(leftParen == -1) return root;
        int parenCount = 0;
        for(int i = leftParen, j = i; i < s.length(); i++,j=i) {
            if(s.charAt(i) == '(') parenCount++;
            else if (s.charAt(i) == ')') parenCount --;
            if(parenCount == 0 && root.left == null) {
                root.left = str2tree(s.substring(leftParen+1,i));
                leftParen = i+1;
            } else if(parenCount == 0) {
                root.right = str2tree(s.substring(leftParen+1,i));
            }
        }
        return root;
    }
}

