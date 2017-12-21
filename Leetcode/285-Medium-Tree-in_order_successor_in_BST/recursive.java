/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Inorder Successor in BST

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

*/



// successor
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return root;
        if(root.val > p.val) {
            TreeNode l = inorderSuccessor(root.left,p);   
            return l==null? root:l;
        } else {
            return inorderSuccessor(root.right,p);
        }
        
    }
}

//predecessor
public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}