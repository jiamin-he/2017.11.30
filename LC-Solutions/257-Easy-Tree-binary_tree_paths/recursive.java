/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 18, 2017
 Problem:    binary tree paths
 Difficulty: esay
 Notes:

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

*/

class Solution1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        path(root,res,"");
        return res;
    }
    public void path(TreeNode root, List<String> res, String s) {
        if(root.left == null && root.right ==null) res.add(s+root.val);
        if(root.left != null) path(root.left, res, s+root.val+"->");
        if(root.right != null) path(root.right, res, s+root.val+"->");
    }
}
