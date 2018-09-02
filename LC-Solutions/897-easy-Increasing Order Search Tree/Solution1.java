/*
Author: Jiamin
Date: Sep 1, 2018
Problem:  Increasing Order Search Tree
Difficulty: easy

Given a binary search tree, rearrange the tree so that the minimum value in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
 
*/
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] res= helper(root);
        return res[0];
    }
    
    public TreeNode[] helper(TreeNode root){
        
        TreeNode[] res = new TreeNode[2];
        if(root.left == null) res[0] = root;
        else {
            TreeNode[] left = helper(root.left);
            left[1].right = root;
            root.left = null;
            res[0] = left[0];
        }
        if(root.right == null) res[1] = root;
        else {
            TreeNode[] right = helper(root.right);
            root.left = null;
            root.right = right[0];
            res[1] = right[1];
        }
        return res;
    }
}