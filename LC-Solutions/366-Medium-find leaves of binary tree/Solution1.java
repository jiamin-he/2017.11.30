/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 28, 2017
 Problem:    Find Leaves of Binary Tree
 Difficulty: Medium
 Notes:

Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].

*/

// 1 ms 10%
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        res.add(new ArrayList<Integer>());
        helper(root, res);
        return res;
    }
    public int helper(TreeNode root, List<List<Integer>> res) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            res.get(0).add(root.val);
            return 1;
        }
        int l = helper(root.left, res);
        int r = helper(root.right, res);
        int m = (l<r?r:l )+ 1;
        if(res.size() < m) {
            res.add(new ArrayList<Integer>());
        }
        res.get(m-1).add(root.val);
        return m;
    }
}