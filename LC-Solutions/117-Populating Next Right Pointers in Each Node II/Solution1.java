/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 04, 2018
 Problem:    Populating Next Right Pointers in Each Node II
 Difficulty: Easy
 Notes:

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        if(root == null) return;
        queue.offer(root);
        int size = queue.size();
        while(!queue.isEmpty()) {
            while(size-- > 0) {
                TreeLinkNode cur = queue.poll();
                if(size != 0) {
                    cur.next = queue.peek();
                }
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            size = queue.size();
        }
    }
}