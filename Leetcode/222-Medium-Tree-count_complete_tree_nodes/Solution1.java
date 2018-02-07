/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Feb 2nd, 2018
 Problem:    count complete tree nodes
 Difficulty: Medium
 Notes:

Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

*/

// 直接bfs用queue数，超时 tlE
// 关注题目要求 是complete binary tree
// O（n）
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()) {
            count++;
            TreeNode temp = q.poll();
            if(temp.left != null) q.offer(temp.left);
            if(temp.right != null) q.offer(temp.right);
        }
        return count;
    }
}


// 利用性质 直接计算最后一层有多少个
// 比上一个跑得快 但还是tle了
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int[] param = new int[2];
        helper(root, param, 0);
        return (int)Math.pow(2,param[0]) -1 + param[1];
    }
    
    public void helper(TreeNode root, int[] param, int level) {
        if(param[0] < level) {
            param[0] = level;
            param[1] = 1;
        } else if(param[0] == level) {
            param[1]++;
        }
        if(root.left != null) helper(root.left, param, level+1);
        if(root.right != null) helper(root.right, param,level+1);
    }
}