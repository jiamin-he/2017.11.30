/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 19, 2017
 Problem:    maximum depth of binary tree
 Difficulty: Easy
 Notes:

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


*/

// mine
// 笨了！！！！看下面更easy的
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
    public int maxDepth(TreeNode root) {
        int[] res = new int[1];
        depth(root,res);
        return res[0];
    }
    public int depth(TreeNode root, int[] res) {
        if(root == null) return 0;
        int d = Math.max(depth(root.left,res), depth(root.right,res)) +1;
        if(d > res[0]) res[0] = d;
        return d;
    }
}

// easy
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
    }
}
