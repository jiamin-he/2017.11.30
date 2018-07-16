/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.



*/

// 5ms 
// 从105 改一改 记得 坐标变化不要写错
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return helper(postorder, inorder, inMap,0, inorder.length-1, 0,postorder.length-1);
    }
    public TreeNode helper(int[] postorder, int[] inorder, Map<Integer, Integer> inMap, int inStart, int inEnd, int postStart, int postEnd) {
        if(postorder == null || postorder.length == 0 || inStart>inEnd || postStart > postorder.length -1) return null;
        if(inStart == inEnd) return new TreeNode(postorder[postEnd]);
        TreeNode curHead = new TreeNode(postorder[postEnd]);
        int i = inMap.get(postorder[postEnd]);
        curHead.left = helper(postorder,inorder,inMap,inStart,i-1,postStart,postStart+i-inStart-1);
        curHead.right = helper(postorder,inorder,inMap, i+1, inEnd,postEnd-inEnd+i, postEnd -1);
        return curHead;
    }
}