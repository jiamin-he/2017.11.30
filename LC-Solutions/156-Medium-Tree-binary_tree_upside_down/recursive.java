/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Count Univalue Subtrees

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
        if(root == null) return 0;
        int[] res = new int[1];
        univalPath(root,res);
        return res[0];
    }
    public boolean univalPath(TreeNode root, int[] res) {
        if(root.left == null && root.right == null) {
            res[0]++;
            return true;
        }
        boolean l, r;
        if(root.left != null && root.right != null) {
            l = univalPath(root.left,res) && root.val == root.left.val;
            r = univalPath(root.right,res) && root.val == root.right.val;
            if( l && r) res[0]++;
            return l&&r;
        }
        else if(root.left != null) {
            l = univalPath(root.left,res) && root.val == root.left.val;
            if(l) res[0]++;
            return l;
        } else {
            r = univalPath(root.right,res) && root.val == root.right.val;
            if(r) res[0]++;
            return r;
        }
    }
}

// 改善一下 各种 if else 的判断
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
        if(root == null) return 0;
        int[] res = new int[1];
        univalPath(root,res);
        return res[0];
    }
    public boolean univalPath(TreeNode root, int[] res) {
        if(root == null) return true;
        boolean l = univalPath(root.left,res), r = univalPath(root.right,res);
        if(l && r) {
            if(root.left != null && root.val != root.left.val) return false;
            if(root.right != null && root.val != root.right.val) return false;
            res[0]++;
            return true;
        }
        return false;
    }
}