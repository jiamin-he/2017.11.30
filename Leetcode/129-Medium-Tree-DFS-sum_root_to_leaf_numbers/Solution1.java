/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.



*/

class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumber(root, 0);
    }
    public int sumNumber ( TreeNode root, int res) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val + res*10;
        return sumNumber(root.left, res*10 + root.val) + sumNumber(root.right, res*10+root.val);
    }
}