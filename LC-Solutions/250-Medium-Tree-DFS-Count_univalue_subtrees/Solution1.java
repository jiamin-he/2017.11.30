/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 2, 2017
 Problem:    Count Univalue Subtrees
 Difficulty: medium
 Notes:

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.


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
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        dfs(root,res);
        return res[0];
    }
    
    public boolean dfs(TreeNode node, int[] res){
        if(node == null) return true;
        boolean left = dfs(node.left,res);
        boolean right = dfs(node.right,res);
        if((node.left == null || node.left.val == node.val) 
           && (node.right == null || node.right.val == node.val)){
            if(left && right){
                res[0]++;
                return true;
            }
        }
        return false;
    }
}