/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


*/

// 3ms 94%
class Solution {
    public int[] findMode(TreeNode root) {
        int[] param = new int[5]; // 0: modeCount 1:maxCount 2:curVal 3: curCount 4:flag for modes
        int[] modes = param;
        inOrder(root, modes, param);
        modes = new int[param[0]];
        param[0] = 0;
        param[2] = 0;
        param[3] = 0;
        param[4] = 1;
        inOrder(root, modes, param);
        return modes;
    }
    public void count(TreeNode root, int[] modes, int[] param) {
        if(root.val != param[2]) {
            param[2] = root.val;
            param[3] = 0;
        }
        param[3]++;
        if(param[3] > param[1]) {
            param[1] = param[3];
            param[0] = 1;
        } else if (param[3] == param[1]) {
            if(param[4] > 0) {
                modes[param[0]] = root.val;
            }
            param[0]++;
        }
    }
    public void inOrder(TreeNode root, int[] modes, int[] param) {
        if(root == null) return;
        inOrder(root.left,modes,param);
        count(root,modes,param);
        inOrder(root.right,modes,param);
    }
}


// Here's Morris traversal, replace it with the inorder traversal

    private void inorder(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
    }