/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 26, 2017
 Problem:    binary tree tilt
 Difficulty: Easy
 Notes:

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

eg

Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1 


*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //int result = 0;

    public int findTilt(TreeNode root){
        
        int[] result = new int[1];
        helper(root, result);
        return result[0];

    }

    private int helper(TreeNode root, int[] result){

        if (root == null) {
            return 0;
        }

        int left = helper(root.left,result);
        int right = helper(root.right,result);

        result[0] += Math.abs(left-right);

        return left + right + root.val;
    }
    
    public static void printPostorder(TreeNode root){

        if (root == null) {
            return;
        }

        printPostorder(root.left);
        printPostorder(root.right);

        System.out.println(root.val + " ");
    }

    public static void printPreorder(TreeNode root){

        if (root == null) {
            return;
        }

        System.out.println(root.val + " ");

        printPreorder(root.left);
        printPreorder(root.right);

        
    }

    public static void printInorder(TreeNode root){

        if (root == null) {
            return;
        }

        printInorder(root.left);

        System.out.println(root.val + " ");
        
        printInorder(root.right);

        
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        

        // System.out.println("post order tree: ");
        // printPostorder(root);

        // System.out.println("pre order tree: ");
        // printPreorder(root);

        // System.out.println("in order tree: ");
        // printInorder(root);

        
        Solution2 s2=new Solution2();
        System.out.println(s2.findTilt(root));



    }
}
