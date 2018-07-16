/*
Author: Jiamin
Date: Dec 18, 2017
Problem: Find Duplicate Subtrees

Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1: 
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.

*/

// 这样不行 因为 输出的结果有重复！！！ 所以要用map记录次数
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        duplicate(root,res);
        return res;
    }
    public String duplicate(TreeNode root, Set<String> set, List<TreeNode> res) {
        if(root == null) return "#";
        String cur = root.val + duplicate(root.left,set,res) + duplicate(root.right,set,res);
        if(set.contains(cur)) {
            res.add(root);
        } else {
            set.add(cur);
        }
        return cur;
    }
}


// correct one
// 34ms 90%
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        duplicate(root,map,res);
        return res;
    }
    public String duplicate(TreeNode root, Map<String,Integer> map, List<TreeNode> res) {
        if(root == null) return "#";
        String cur = root.val + duplicate(root.left,map,res) + duplicate(root.right,map,res);
        int temp = map.getOrDefault(cur,0);
        if(temp == 1) {
            res.add(root);
        } 
        map.put(cur, temp+1);
        return cur;
    }
}