/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 23, 2017
 Problem:    Binary Search Tree Iterator
 Difficulty: Medium
 Notes:
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public void pushAll(TreeNode node) {
        while(node!=null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */


// Sep 26 2018 review
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Deque<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        pushAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if(top.right != null) {
                stack.pop();
                pushAllLeft(top.right);
                stack.push(top);
            }
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop().val;
    }
    
    public void pushAllLeft(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */