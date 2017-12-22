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

// 14ms 17%
class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }
    
    // return 0 is increasing length, 1 is decreasing length
    public int[] helper(TreeNode root, int[] max) {
        int[] cur = new int[2];
        cur[0] = 1; cur[1] = 1;
        if(root == null) return cur;
        int[] l = helper(root.left,max);
        int[] r = helper(root.right,max);
        if(root.left != null) {
            if(root.val == root.left.val + 1) cur[0] = l[0] + 1;
            else cur[0] = 1;
            if(root.val == root.left.val - 1) cur[1] = l[1] + 1;
            else cur[1] = 1;
        }
        if(root.right != null) {
            if(root.val == root.right.val + 1) cur[0] = Math.max(cur[0], r[0] + 1);
            if(root.val == root.right.val - 1) cur[1] = Math.max(cur[1], r[1] + 1);
        }
        if(cur[0] > 1 && cur[1] > 1) max[0] = Math.max(max[0], cur[0]+ cur[1] -1);
        else if(cur[0] == 1) max[0] = Math.max(max[0],cur[1]);
        else max[0] = Math.max(max[0], cur[0]);
        return cur;
    }
}