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

// 记得 l 和 r 要加一句 math max 跟0cp
// 如果返回来的是个负数 咱就不要他了 从0起
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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxSum(root, res);
        return res[0];
    }
    public int maxSum(TreeNode root, int[] res) {
        if(root == null) return 0;
        int l = Math.max(0,maxSum(root.left,res)), r = Math.max(0,maxSum(root.right,res));
        res[0] = Math.max(res[0], l + r + root.val );
        return Math.max(l,r) + root.val;
    }
}