/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Minimum Absolute Difference in BST
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.


*/

// Make use of the property of BST that value of nodes is bounded by their "previous" and "next" node.
// But !! look down!!
class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return min;
    }
    public void helper(TreeNode root, int lower, int upper) {
        if(root == null) return;
        if(lower != Integer.MIN_VALUE) {
            min = Math.min(min, root.val - lower);
        }
        if(upper != Integer.MAX_VALUE) {
            min = Math.min(min, upper - root.val);
        }
        helper(root.left, lower, root.val);
        helper(root.right, root.val, upper);
    }
}

// The above one will fail for the test case [Integer.MAX_VALUE, something else].
// because it is in the else clause!!!
// so should change the Integer.... to Long.MAX_VALUE;
class Solution {
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return (int)min;
    }
    public void helper(TreeNode root, long lower, long upper) {
        if(root == null) return;
        if(lower != Long.MIN_VALUE) {
            min = Math.min(min, root.val - lower);
        }
        if(upper != Long.MAX_VALUE) {
            min = Math.min(min, upper - root.val);
        }
        helper(root.left, lower, root.val);
        helper(root.right, root.val, upper);
    }
}