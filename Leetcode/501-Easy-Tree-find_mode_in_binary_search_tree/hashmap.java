/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Find Mode in Binary Search Tree

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

*/

//这个方法对所有的tree都适合用
//但是没有用上这个是个bst的性质
//也不满足follow up
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        if(root == null) return new int[0];
        int[] res = new int[1];
        preOrder(root,map,res);
        List<Integer> modeList = new ArrayList<>();
        for(Integer i : map.keySet()) {
            if (map.get(i) == res[0]) modeList.add(i);
        }
        int[] modeArray = new int[modeList.size()];
        for(int i = 0; i < modeList.size(); i++) {
            modeArray[i] = modeList.get(i);
        }
        return modeArray;
        
    }
    public void preOrder(TreeNode root, Map<Integer,Integer> map, int[] res) {
        if(root == null) return;
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        if(map.get(root.val) > res[0]) res[0] = map.get(root.val);
        preOrder(root.left,map,res);
        preOrder(root.right,map,res);
    }
}