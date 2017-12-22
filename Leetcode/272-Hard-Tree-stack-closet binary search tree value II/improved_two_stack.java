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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// 记住 如果相等的时候不加进去stack 是不行的 最后结果不对 （会漏加了别的closed的）所以要加
// 但是相等的时候都加进去的话会有一个重复了 所以要先在前面pop且去掉一个
// 3ms 75%
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> pre = new ArrayDeque<>();
        Deque<TreeNode> succ = new ArrayDeque<>();
        
        buildPre(root, target, pre);
        buildSucc(root, target, succ);
        if(!pre.isEmpty() && !succ.isEmpty() && succ.peek().val == pre.peek().val) {
            getPre(res,pre);
            res.remove(0);
        }
        
        while(k-- > 0) {
            if(pre.isEmpty()) {
                getSucc(res, succ);
            } else if (succ.isEmpty()) {
                getPre(res, pre);
            } else if ((double)Math.abs((double)succ.peek().val - target) < (double)Math.abs((double)pre.peek().val - target)) {
                getSucc(res, succ);
            } else {
                getPre(res, pre);
            }
        }
        return res;
    }
    public void buildPre(TreeNode root, double target, Deque<TreeNode> stack) {
        while(root != null) {
            if(root.val > target) {
                root = root.left;
            } else if(root.val < target) {
                stack.push(root);
                root = root.right;
            } else {
                stack.push(root);
                return;
            }
        }
    }
    public void buildSucc(TreeNode root, double target, Deque<TreeNode> stack) {
        while(root != null) {
            if(root.val < target) {
                root = root.right;
            } else if(root.val > target) {
                stack.push(root);
                root = root.left;
            } else {
                stack.push(root);
                return;
            }
        }
    }
    public void getPre(List<Integer> res, Deque<TreeNode> stack) {
        TreeNode cur = stack.pop();
        res.add(cur.val);
        cur = cur.left;
        while(cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
    }
    public void getSucc(List<Integer> res, Deque<TreeNode> stack) {
        TreeNode cur = stack.pop();
        res.add(cur.val);
        cur = cur.right;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}