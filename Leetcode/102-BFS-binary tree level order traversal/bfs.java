/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 24, 2017
 Problem:    binary tree level order traversal
 Difficulty: Medium
 Notes:
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.offer(root);
        int size = q.size();
        while(!q.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            while(size-- > 0) {
                TreeNode temp = q.poll();
                cur.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);   
            }
            res.add(cur);
            size = q.size();
        }
        return res;
    }
}