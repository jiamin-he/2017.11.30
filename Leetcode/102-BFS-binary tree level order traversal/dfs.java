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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}


// Feb 2nd review
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res, 0);
        return res;
    }
    
    public void helper(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) return;
        if(level >= res.size()) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);
    }
}