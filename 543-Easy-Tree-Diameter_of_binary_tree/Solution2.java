/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 28, 2017
 Problem:    Diameter of Binary Tree
 Difficulty: Easy
 Notes:

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

eg

Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.


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

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root){
        return DFS(root)[0];

    }

    private int[] DFS(TreeNode node){

        if (node == null) return new int[] { 0, 0 };
        int[] left = DFS(node.left);
        int[] right = DFS(node.right);
        
        int best = Math.max(left[1] + right[1], Math.max(left[0], right[0]));
        int height = 1 + Math.max(left[1], right[1]);
        return new int[] { best, height };
    }
    
    public static void printLevelorder(TreeNode root){

        int h = height(root);
        int i;
        for (i=1; i<=h ; i++ ) {
            printGivenLevel(root,i);
        }
    }

    public static void printGivenLevel(TreeNode root, int level){
        if (root == null) {
            return;
        }
        if (level ==1) {
            System.out.print(root.val + " ");
        } else if (level >1) {
            printGivenLevel(root.left, level -1);
            printGivenLevel(root.right, level -1);
        }
    }

    private static int height(TreeNode root){
        if (root == null) {
            return 0;
        } else{
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight > rightHeight) {
                return leftHeight+1;
            } else return rightHeight +1;
        }
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
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        

        // System.out.println("post order tree: ");
        // printPostorder(root);

        // System.out.println("pre order tree: ");
        // printPreorder(root);

        // System.out.println("in order tree: ");
        // printInorder(root);
        
        
        //System.out.println("level order tree: ");
        //printLevelorder(root);

        // how to test "static variable -- value shared"
        // Solution1 s1 = new Solution1();
        // System.out.println(s1.diameterOfBinaryTree());
        // Solution1 s2 = new Solution1();
        // System.out.println(s2.diameterOfBinaryTree());
        Solution2 s2 = new Solution2();
        System.out.println(s2.diameterOfBinaryTree(root));
        

    }
}
