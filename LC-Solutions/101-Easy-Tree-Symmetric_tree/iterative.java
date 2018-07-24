/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:      July 24, 2018
 Problem:    Symmetric Tree
 Difficulty: Easy
 Notes:

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

eg

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3


Note:
Bonus points if you could solve it both recursively and iteratively.

*/

// review.
// similar to 100. (change the order when adding to qq.)
// 8ms 94%

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> qp = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        qp.offer(root.left);
        qq.offer(root.right);
        while(!qp.isEmpty() && !qq.isEmpty()){
            TreeNode temP = qp.poll();
            TreeNode temQ = qq.poll();
            if(temP == null && temQ == null){
                continue;
            } 
            if(temP != null && temQ != null && temP.val == temQ.val) {
                qp.offer(temP.left);
                qp.offer(temP.right);
                qq.offer(temQ.right);
                qq.offer(temQ.left);
            } else {
                return false;
            }
        }
        return qp.isEmpty()&&qq.isEmpty();
    }
}