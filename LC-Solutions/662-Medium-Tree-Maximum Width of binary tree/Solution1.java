/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 24, 2017
 Problem:    Maximum width of binary tree
 Difficulty: Medium
 Notes:

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 48ms 3%
// bfs, add "fail" node to denote the null node inside.
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int maxWid = 0;
        int size = 0, wid = 0;
        TreeNode fail = new TreeNode(0);
        while(!deque.isEmpty()) {
            while(deque.peekFirst() == fail) deque.pollFirst();
            while(deque.peekLast() == fail) deque.pollLast();
            size = deque.size();
            wid = 0;
            if(size == 0) return maxWid;
            if(size == 1) wid = 1;
            else wid = size;
            while(size-- > 0) {
                TreeNode cur = deque.pollFirst();
                if(cur.left == null) deque.offerLast(fail);
                else deque.offerLast(cur.left);
                if(cur.right == null) deque.offerLast(fail);
                else deque.offerLast(cur.right);
            }
            if(wid > maxWid) maxWid = wid;
        }
        return maxWid;
    }
}