/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 14, 2017
 Problem:    Binary Tree Inorder Traversal
 Difficulty: medium
 Notes:

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?


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
    
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();    
    //     if(root == null) return res;
    //     inorder(root,res);
    //     return res;
    // }
    // public void inorder (TreeNode root, List<Integer> res) {
    //     if(root == null) return;
    //     inorder(root.left,res);
    //     res.add(root.val);
    //     inorder(root.right,res);
    //     return;
    // }

	// 这种写法更加简洁哦
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();    
        if(root != null) {
            inorder(root,res);
        }
        return res;
    }
    public void inorder (TreeNode root, List<Integer> res) {
        if(root != null) {
	        inorder(root.left,res);
	        res.add(root.val);
	        inorder(root.right,res);
    	}
    }
}
