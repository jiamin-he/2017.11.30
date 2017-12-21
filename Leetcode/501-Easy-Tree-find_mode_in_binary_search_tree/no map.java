/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Find Mode in Binary Search Tree

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

*/


// 多用了空间
// 但是是1pass
// 内核跟2pass一样 
// 只是用了空间换时间而已
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
    public int[] findMode(TreeNode root) {
        int[] param = new int[5]; // 0: modeCount 1:maxCount 2:curVal 3: curCount
        List<Integer> list = new ArrayList<>();
        inOrder(root, list, param);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
    public void count(TreeNode root, List<Integer> list, int[] param) {
        if(root.val != param[2]) {
            param[2] = root.val;
            param[3] = 0;
        }
        param[3]++;
        if(param[3] > param[1]) {
            param[1] = param[3];
            list.clear();
            list.add(root.val);
        } else if (param[3] == param[1]) {
            list.add(root.val);
        }
    }
    public void inOrder(TreeNode root, List<Integer> list, int[] param) {
        if(root == null) return;
        inOrder(root.left,list,param);
        count(root,list,param);
        inOrder(root.right,list,param);
    }
}