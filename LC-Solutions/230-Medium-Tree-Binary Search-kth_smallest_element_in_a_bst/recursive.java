/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 18, 2017
 Problem:    Kth smallest element in a bst
 Difficulty: medium
 Notes:

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

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
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return result;
    }
    public void helper(TreeNode root, int k) {
        if(root == null) return;
        helper(root.left,k);
        count++;
        if(count == k) result = root.val;
        helper(root.right,k);
    }
}
