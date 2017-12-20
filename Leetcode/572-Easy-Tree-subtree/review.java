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

// 48ms 5% 太慢了

class Solution1 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tStr = tree(t);
        String sStr = tree(s);
        return sStr.contains(tStr);
    }
    public String tree(TreeNode root) {
        if(root == null) return "#";
        String cur = root.val +","+ tree(root.left) + tree(root.right);
        return cur;
    }
}
