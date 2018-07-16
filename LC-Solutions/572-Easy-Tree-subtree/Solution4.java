/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 18, 2017
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


class Solution {
   public boolean isSubtree(TreeNode s, TreeNode t) {
         return isSubHelper(s, t, false);
     }
    private boolean isSubHelper(TreeNode s, TreeNode t, boolean fix) {
        if(s==null&&t==null) return true;
        else if(s!=null&&t!=null) {
            if(fix==true&&s.val!=t.val) return false;
            if(s.val==t.val)  {
                if(isSubHelper(s.left, t.left, true)&&isSubHelper(s.right, t.right, true)) return true;
            }
            if(isSubHelper(s.right, t, false)) return true;
            if(isSubHelper(s.left, t, false)) return true;
            return false;
        } else {
            return false;
        }
    }
}