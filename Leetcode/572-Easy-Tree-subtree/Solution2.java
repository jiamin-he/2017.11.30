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

    //别人的 
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s); 
        String tpreorder = generatepreorderString(t);
        
        return spreorder.contains(tpreorder) ;
    }
    public String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while(!stacktree.isEmpty()){
           TreeNode popelem = stacktree.pop();
           if(popelem==null)
              sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
           else      
              sb.append(","+popelem.val);
           if(popelem!=null){
                stacktree.push(popelem.right);    
                stacktree.push(popelem.left);  
           }
        }
        return sb.toString();
    }






















    //自己写一次
    public boolean isSubtree1(TreeNode t1, TreeNode t2){
      String st1 = buildString1(t1);
      String st2 = buildString1(t2);
      return st1.contains(st2);
    }

    public String buildString1(TreeNode t1){
      StringBuilder s = new StringBuilder();
      Stack<TreeNode> st = new Stack();
      st.push(t1);
      while(!st.isEmpty()){
        TreeNode tmp = st.pop();
        if(tmp == null) s.append(",#");
        else {
          s.append(","+tmp.val); //逗号不可以放在后面啊啊！12 和 2 产出来后面都一样 这样会误判的
          st.push(tmp.left);
          st.push(tmp.right);
        }
      }
      return s.toString();
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(12);
        TreeNode t2 = new TreeNode(2);
    }
}
