/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 2, 2017
 Problem:    longest univalue path
 Difficulty: easy
 Notes:

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
*/

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
    public int longestUnivaluePath(TreeNode root) {
        return dfs(root);
    }
    
    public int dfs(TreeNode node){
        if(node == null) return 0;
        int left = 0, right = 0, resL = 0, resR = 0;
        left = dfs(node.left, res);
        right = dfs(node.right, res);
        if(node.left != null && node.left.val == node.val) resL = ++left;
        if(node.right != null && node.right.val == node.val) resR = ++right;
        res[0] = Math.max(res[0],resL + resR);
        return Math.max(resL,resR);
        
    }
}