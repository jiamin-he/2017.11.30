/*
Author: Jiamin
Date: Dec 21, 2017
Problem: Closest Binary Search Tree Value II
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
*/


// 4 ms 56% 
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> pre = new ArrayDeque<>();
        Deque<TreeNode> succ = new ArrayDeque<>();
        inorder(root, target, pre, true);
        inorder(root, target, succ, false);
        
        while(k-- > 0) {
            if(pre.isEmpty()) {
                res.add(succ.pop().val);
            } else if (succ.isEmpty()) {
                res.add(pre.pop().val);
            } else if (Math.abs(succ.peek().val - target) < Math.abs(pre.peek().val - target)) {
                res.add(succ.pop().val);
            } else {
                res.add(pre.pop().val);
            }
        }
        return res;
    }
    public void inorder(TreeNode root, double target, Deque<TreeNode> stack, boolean dire) {
        if(root == null) return;
        inorder(dire?root.left:root.right, target, stack, dire);
        if((dire && root.val >= target) || (!dire && root.val < target)) return;
        stack.push(root);
        inorder(dire?root.right:root.left, target, stack, dire);
    }
}