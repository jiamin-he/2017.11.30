/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.



*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = new int[] {0};
        int[] inIndex = new int[] {0};
        return buildTree(preorder, inorder, preIndex, inIndex, Integer.MAX_VALUE);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int[] preIndex, int[] inIndex, int target) {
        //pre: [root][left][right];
        //in: [left][root][right];
        //target is the root
        if (inIndex[0] >= inorder.length || inorder[inIndex[0]] == target) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        //preorder, advance the index by 1 sice we already finish the root;
        preIndex[0]++;
        root.left = buildTree(preorder, inorder, preIndex, inIndex, root.val);
        //after finishing left subtree, we can advance the index by 1
        inIndex[0]++;
        root.right = buildTree(preorder, inorder, preIndex, inIndex, target);
        return root;
    }
}

