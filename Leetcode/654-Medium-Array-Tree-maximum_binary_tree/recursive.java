/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Maximum Binary Tree

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].


*/

// 处理好传参及退出值即可
// 13ms 61%
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int start, int end) {
        if(start > nums.length - 1 || start > end) return null;
        int max = nums[start], pos = start;
        for(int i = start+1; i<= end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, pos-1);
        root.right = helper(nums, pos+1, end);
        return root;
    }
}