/*
Author: Jiamin
Date: Dec 21, 2017
Problem: Binary Tree Longest Consecutive Sequence

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

*/


// 2 ms 
class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] param = new int[2]; // param[0] is current value, param[1] is max value
        if(root == null) return 0;
        helper(root, param, root.val);
        return param[1];
    }
    public void helper(TreeNode root, int[] param, int target) {
        if(root == null) {
            return;
        }
        if(root.val == target) {
            param[0]++;
            if(param[0] > param[1]) param[1] =param[0];
        } else {
            param[0] = 1;
        }
        int temp = param[0];
        helper(root.left, param, root.val+1);
        param[0] = temp;
        helper(root.right, param, root.val+1);
    }
}