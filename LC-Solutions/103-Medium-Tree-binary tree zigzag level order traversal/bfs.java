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

// 2ms
// 27%
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true; // true is from left to right
        int size = q.size();
        while(!q.isEmpty()) {
            List<Integer> cur = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = q.poll();                
                if(flag) cur.add(temp.val);
                else cur.add(0,temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            size = q.size();
            res.add(cur);
            flag = !flag;
        }
        return res;
    }
}