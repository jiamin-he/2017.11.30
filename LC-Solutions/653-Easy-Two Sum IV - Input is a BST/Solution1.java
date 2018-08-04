/*
Author: Jiamin
Date: Jul 29, 2018
Problem: Two Sum IV - Input is a BST
Difficulty: easy

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/

// 18ms 64%
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return false;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode r = q.poll();
            if(set.contains(r.val)) return true;
            set.add(k-r.val);
            if(r.left != null) q.offer(r.left);
            if(r.right != null) q.offer(r.right);
        }
        return false;
    }
}


// 18ms 64%
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
    public boolean helper(TreeNode root, int k, Set<Integer> set){
        if(root == null) return false;
        if(set.contains(root.val)) return true;
        set.add(k-root.val);
        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}