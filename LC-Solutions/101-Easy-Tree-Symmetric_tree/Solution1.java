/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 28, 2017
 Problem:    Symmetric Tree
 Difficulty: Easy
 Notes:

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

eg

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3


Note:
Bonus points if you could solve it both recursively and iteratively.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return Compare(root.left, root.right);
    }

    public boolean Compare(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        // else if (t1 == null || t2==null) return false;
        // else if (t1.val == t2.val) {
        //     return Compare(t1.left, t2.right) && Compare(t1.right, t2.left);
        // } else return false;
        else if (t1 == null || t2 == null || t1.val != t2.val) return false;
        return Compare(t1.left, t2.right) && Compare(t1.right, t2.left);
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
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.left.left.left = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // System.out.println("post order tree: ");
        // printPostorder(root);

        // System.out.println("pre order tree: ");
        // printPreorder(root);

        // System.out.println("in order tree: ");
        // printInorder(root);
        
        
        //System.out.println("level order tree: ");
        //printLevelorder(root);

        // how to test "static variable -- value shared"
        Solution1 s1 = new Solution1();
        System.out.println(s1.isSymmetric(root));
        

    }
}
