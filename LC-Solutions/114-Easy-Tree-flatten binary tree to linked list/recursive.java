/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

*/

// 自己画一下 要弄明白 一定要先right 再left
// 18 ms 14%
// 下面还有一种recursive的方法
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return ;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}

// 14ms 80%
// 因为无法得到尾节点的值 所以要自己一个一个移过去
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}

