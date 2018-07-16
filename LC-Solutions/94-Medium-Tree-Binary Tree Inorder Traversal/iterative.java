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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();    
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root!=null) {
            if(root!= null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.peek();
                s.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
