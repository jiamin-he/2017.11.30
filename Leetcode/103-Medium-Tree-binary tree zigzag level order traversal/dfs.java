/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

*/

// 2ms 24%
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, res, 1);
        return res;
    }
    public void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) return;
        if(res.size() < level) {
            List<Integer> cur = new LinkedList<>();
            res.add(cur);
        }
        if(level % 2 != 0) {
            res.get(level-1).add(root.val);    
        } else {
            res.get(level-1).add(0, root.val);
        }
        dfs(root.left, res, level+1);
        dfs(root.right,res, level+1);
    }
}