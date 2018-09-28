/*
Author: Jiamin
Date: Dec 18, 2017
Problem: Balanced binary tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

*/



// 这样会有test case 过不去！因为设置了上下界，但如果val本来就是你设定的上下界的时候就fail了
// 可以改用Long.MAX_VALUE /... 来替换 就可以了
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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    public boolean isValid(TreeNode root, int maxVal, int minVal) {
        if(root.val >= maxVal || root.val <= minVal) return false;
        boolean res = true;
        if(root.left != null) {
            res = isValid(root.left, root.val, minVal);
        }
        if(res && root.right != null) {
            res = isValid(root.right, maxVal, root.val);
        }
        return res;
    }
}


// AC （用 long max value）
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    public boolean isValid(TreeNode root, long maxVal, long minVal) {
        if(root.val >= maxVal || root.val <= minVal) return false;
        boolean res = true;
        if(root.left != null) {
            res = isValid(root.left, root.val, minVal);
        }
        if(res && root.right != null) {
            res = isValid(root.right, maxVal, root.val);
        }
        return res;
    }
}