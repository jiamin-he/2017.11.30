/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Inorder Successor in BST

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

*/

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while(root != null) {
            if(root.val > p.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}


// Sep 8th 2018
// 其实找不找到p真的不重要的！
// 2ms 100%
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode parent = null;
        while(p.val != root.val) {
            if(p.val > root.val) {
                root = root.right;
            } else {
                parent = root;
                root = root.left;
            }
        }
        if(root.right == null) return parent;
        else root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}