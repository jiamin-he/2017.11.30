/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Binary Tree Maximum Path Sum

Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.


*/

class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumber(root, 0);
    }
    public int sumNumber ( TreeNode root, int res) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val + res*10;
        return sumNumber(root.left, res*10 + root.val) + sumNumber(root.right, res*10+root.val);
    }
}