/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Closest Binary Search Tree Value
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

*/

public class Solution {
    public int closestValue(TreeNode root, double target) {
        return closest(root, target, root.val);
    }
    
    private int closest(TreeNode node, double target, int val) {
        if (node == null) return val;
        if (Math.abs(node.val - target) < Math.abs(val - target)) val = node.val;
        if (node.val < target) val = closest(node.right, target, val);
        else if (node.val > target) val = closest(node.left, target, val);
        return val;
    }
}