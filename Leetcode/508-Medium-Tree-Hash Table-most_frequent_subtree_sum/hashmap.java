/*
Author: Jiamin
Date: Dec 18, 2017
Problem: Most Frequent Subtree Sum

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

*/


// 17ms 68%
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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] maxCount = new int[1];
        ArrayList<Integer> res = new ArrayList<>();
        sumTree(root,map,maxCount);
        for(Integer i: map.keySet()) {
            if(map.get(i) == maxCount[0]) res.add(i);
        }
        int[] res2 = new int[res.size()];
        for(int i=0; i < res.size(); i++) {
            res2[i] = res.get(i);
        }
        return res2;
    }
    
    public int sumTree(TreeNode root, Map<Integer,Integer> map, int[] maxCount) {
        if(root == null) return 0;
        int l = sumTree(root.left,map,maxCount);
        int r = sumTree(root.right,map,maxCount);
        int s = l+r+root.val;
        int count = map.getOrDefault(s,0)+1;
        map.put(s,count);
        maxCount[0] = Math.max(maxCount[0],count);
        return s;
    }
}
