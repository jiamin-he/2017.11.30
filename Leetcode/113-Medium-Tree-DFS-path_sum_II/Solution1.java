/*
Author: Jiamin
Date: Dec 19, 2017
Problem: path sum

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

// 这样写 出来的永远是空 为什么！！！
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        path(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    public void path(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if(root == null) return;
        cur.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) res.add(cur);
        path(root.left,sum,cur,res);
        path(root.right,sum,cur,res);
        
        cur.remove(cur.size()-1);
    }
}

// 看res.add那里！ 直接把cur加进去的话 会随着后面cur变而变
// 后面cur都被remove掉了 自然是空
// 应该新建一个新的list放进去！
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        path(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    public void path(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if(root == null) return;
        cur.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) res.add(new ArrayList<>(cur));
        path(root.left,sum,cur,res);
        path(root.right,sum,cur,res);
        
        cur.remove(cur.size()-1);
    }
}