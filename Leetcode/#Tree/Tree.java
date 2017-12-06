/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 17, 2017
 Problem:    tree
 Results:


*/

import java.util.Queue;
import java.util.LinkedList;

class Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void printLevelorder1(TreeNode root){

        int h = height(root);
        int i;
        for (i=1; i<=h ; i++ ) {
            printGivenLevel(root,i);
        }
    }

    public static void printLevelorder2(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            /*TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            if (tempNode.left!=null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right !=null) {
                queue.add(tempNode.right);
            }*/
            TreeNode temp = queue.remove();
            if(temp.left != null && temp.right != null && temp.left.val == temp.right.val){
                queue.add(temp.left);
                queue.add(temp.right);
            }
            else if(temp.left == null || temp.right == null)
                continue;
            else
                return false;
        }
        return true;
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

        System.out.println("level order tree: ");
        printLevelorder2(root);


    }
}
