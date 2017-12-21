/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.



*/

// 60ms 1%
// 这么慢 是因为我总在创建新数组
// 其实可以不用创建新数组 只告诉他起点和终点在哪里就好了！
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode curHead = new TreeNode(preorder[0]);
        int i = 0;
        for(; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]) break;
        }
        int[] inorderLeft = new int[i],  preorderLeft = new int[i],
            inorderRight = new int[inorder.length - i -1],
            preorderRight = new int[inorder.length - i -1];
        for(int j = 0; j < inorder.length;j++) {
            if(j < i) inorderLeft[j] = inorder[j];
            else if(j > i) inorderRight[j-i-1] = inorder[j];
        }
        for(int j = 1; j < preorder.length;j++) {
            if(j <= i) preorderLeft[j-1] = preorder[j];
            else preorderRight[j-i-1] = preorder[j];
        }
        curHead.left = buildTree(preorderLeft,inorderLeft);
        curHead.right = buildTree(preorderRight,inorderRight);
        return curHead;
    }
}

// 自己打草稿想清楚各个index是怎么传过去的
// 17ms 57%
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length-1, 0);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart) {
        if(preorder == null || preorder.length == 0 || inStart>inEnd || preStart > preorder.length -1) return null;
        if(inStart == inEnd) return new TreeNode(preorder[preStart]);
        TreeNode curHead = new TreeNode(preorder[preStart]);
        int i = inStart;
        for(; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]) break;
        }
        curHead.left = helper(preorder,inorder,inStart,i-1,preStart+1);
        curHead.right = helper(preorder,inorder, i+1, inEnd,preStart+i+1-inStart);
        return curHead;
    }
}

// 发现每次都在找对应位置 放在map里就不用每次去scan找了！
// 5ms 80%
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}

