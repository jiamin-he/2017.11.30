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


// Aug 2nd 2018 review
// 17ms 2%
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        StringBuilder sb = new StringBuilder((Integer.toString(root.val)));
        if(root.left != null)dfs(root.left, sb, res);
        if(root.right != null)dfs(root.right, sb, res);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        return res;
    }
    public void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        
        int size = sb.length();
        sb.append("->"+root.val);
        if(root.left != null) dfs(root.left, sb, res);
        if(root.right != null) dfs(root.right, sb, res);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        sb.delete(size,sb.length());
    }
}


// 先append value 再加箭头 最后一个不加箭头
// 13ms 8%
// 用stringbuilder记得要回删
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, new StringBuilder(), res);
        return res;
    }
    public void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            int size = sb.length();
            sb.append(root.val);
            res.add(sb.toString());
            sb.delete(size, sb.length());
            return;
        }
        int size = sb.length();
        sb.append(root.val+"->");
        if(root.left != null) dfs(root.left, sb, res);
        if(root.right != null) dfs(root.right, sb, res);
        sb.delete(size,sb.length());
    }
}


// Sep 19th 2018 review
// 18ms 8%
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, res, "");
        return res;
    }
    
    public void dfs(TreeNode cur, List<String> res, String current) {
        if(cur.left == null && cur.right == null) {
            current += Integer.toString(cur.val);
            res.add(current);
        } else {
            current += Integer.toString(cur.val) +"->";
            if(cur.left != null) dfs(cur.left, res, current);
            if(cur.right != null) dfs(cur.right, res, current);
        }
        
    }
}