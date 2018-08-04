/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 25, 2017
 Problem:    same tree
 Difficulty: easy
 Notes:
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.


Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false


*/

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Queue<TreeNode> qp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        qp.offer(p);
        qq.offer(q);
        while(!qp.isEmpty() && !qq.isEmpty()) {
            TreeNode tempP = qp.poll();
            TreeNode tempQ = qq.poll();
            if(tempP.val != tempQ.val) return false;
            if(tempP.left != null && tempQ.left != null) {
                qp.offer(tempP.left);
                qq.offer(tempQ.left);
            } else if (tempP.left != null || tempQ.left != null) {
                return false;
            }
            if(tempP.right != null && tempQ.right != null) {
                qp.offer(tempP.right);
                qq.offer(tempQ.right);
            } else if (tempP.right != null || tempQ.right != null) {
                return false;
            }
        }
        return true;
    }
}


// 3ms 98%
// Jul 24, 2018
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> qp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        qp.offer(p);
        qq.offer(q);
        while(!qp.isEmpty() && !qq.isEmpty()){
            TreeNode temP = qp.poll();
            TreeNode temQ = qq.poll();
            if(temP == null && temQ == null){
                continue;
            } 
            if(temP != null && temQ != null && temP.val == temQ.val) {
                qp.offer(temP.left);
                qp.offer(temP.right);
                qq.offer(temQ.left);
                qq.offer(temQ.right);
            } else {
                return false;
            }
        }
        return qp.isEmpty()&&qq.isEmpty();
    }
}