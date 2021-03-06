/*
Author: Jiamin
Date: Dec 18, 2017
Problem: Balanced binary tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

// 太多递归 占用太多内存空间 如何改进？？
// level 被计算太多次了 应该要存起来！
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int abs = Math.abs(level(root.right)-level(root.left));
        return isBalanced(root.left) && isBalanced(root.right) && abs<2;
    }
    
    public int level(TreeNode root) {
        if(root == null) return 0;
        return Math.max(level(root.left),level(root.right))+1;
    }
}


//把两个函数的功能合在一起
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
    public boolean isBalanced(TreeNode root) {
        if(helper(root) == -1) return false;
        return true;
    }
    
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left), right = helper(root.right);
        if(left == -1) return -1;
        if(right == -1) return -1;
        if(Math.abs(left-right)<2) return Math.max(left,right)+1;
        return -1;
    }
}


// July 25th 2018 review
// 1ms 75%
// 可以不用设置res数组来传值，直接让他return -1 就表示fail就可以了
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
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[]{true};
        helper(root,res);
        return res[0];
    }
        
    public int helper(TreeNode root, boolean[] res) {
        if(root == null) return 0;
        int left = helper(root.left, res), right = helper(root.right,res);
        if(res[0] == true && Math.abs(left-right) > 1) {
            res[0] = false;
        }
        return Math.max(left,right)+1;
    }
}

// improved version

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
    public boolean isBalanced(TreeNode root) {
        int res = helper(root);
        return res == -1? false:true;
    }
        
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left), right = helper(root.right);
        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left,right)+1;
    }
}