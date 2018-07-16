/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 02, 2017
 Problem:    subtree
 Difficulty: esay
 Notes:

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

*/

import java.util.*;

class Solution1 {

    /*
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2 == null ) return true;
        if(T1 == null) return false;
        if(T1.val == T2.val && compareSubtree(T1,T2)) return true;
        return (isSubtree(T1.left, T2) || isSubtree(T1.right,T2));
    }

    public boolean compareSubtree (TreeNode T1, TreeNode T2){
        if(T1 == null && T2 == null) return true;
        if(T1 == null || T2 == null) return false;
        return (T1.val == T2.val && 
            compareSubtree(T1.left, T2.left) && compareSubtree(T1.right,T2.right)); 
    }

    public static void main(String[] args) {

    }
}
