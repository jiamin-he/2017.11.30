/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
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
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

*/


//it is DFS so u need a stack. Dont forget to set the left child to null, or u'll get TLE. (tricky!)
//很棒的解法！！！
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.right!=null)  
                 stack.push(cur.right);
            if (cur.left!=null)  
                 stack.push(cur.left);
            if (!stack.isEmpty()) 
                 cur.right = stack.peek();
            cur.left = null;  
        }
    }
}