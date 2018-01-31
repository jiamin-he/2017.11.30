/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 28, 2017
 Problem:    Find Bottom Left Tree Value
 Difficulty: Medium
 Notes:

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.

*/

// 7 ms 70%
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
    public int findBottomLeftValue(TreeNode root) {
        int[] res = helper(root);
        return res[0];
    }
    public int[] helper(TreeNode root) {
        if(root == null) return new int[] {0,0};
        if(root.left == null && root.right == null) return new int[] {root.val,1};
        int[] a = new int[2], b = new int[2];
        if(root.left != null) a = helper(root.left);
        if(root.right != null) b = helper(root.right);
        if(a[1] >= b[1]) return new int[] {a[0], a[1]+1};
        else return new int[] {b[0],b[1]+1};
        
    }
}