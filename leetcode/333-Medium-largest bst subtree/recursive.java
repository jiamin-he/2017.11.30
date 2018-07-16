/*
Author: Jiamin
Date: July 15, 2018
Problem: largest bst subtree
Difficulty: medium

Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
*/



// 4ms 100%
// O(n)
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
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        res[0] = 1;
        findHelper(root, res);
        return res[0];
    }
    
    public int[] findHelper(TreeNode root, int[] res){
        // the return array, {max, min, valid bit, cur size}
        // res[] stores the max result 
        if(root == null) return null;
        int[] left = findHelper(root.left, res);
        int[] right = findHelper(root.right, res);
        if(left == null && right == null) return new int[]{root.val, root.val, 1, 1};
        else if (left == null) {
            if(right[2] == 1 && right[1] > root.val){
                right[1] = root.val; 
                right[3]++;
                res[0] = Math.max(res[0], right[3]);
            } else {
                right[2] = 0;
            }
            return right;
        } else if(right == null){
            if(left[2] == 1 && left[0] < root.val){
                left[0] = root.val; 
                left[3]++;
                res[0] = Math.max(res[0], left[3]);
            } else {
                left[2] = 0;
            }
            return left;
        } else if(left[2] == 1 && right[2] == 1 && left[0] < root.val && right[1] > root.val){
            // both of them are not null, and still valid
            res[0] = Math.max(res[0], left[3]+right[3]+1);
            return new int[] {right[0],left[1], 1, left[3]+right[3]+1};
        }
        return new int[] {0,0,0,0};
    }
}