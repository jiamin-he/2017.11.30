/*
Author: Jiamin
Date: Dec 21, 2017
Problem: Boundary of Binary Tree

Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1
Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
Example 2
Input:
    ____1_____
   /          \
  2            3
 / \          / 
4   5        6   
   / \      / \
  7   8    9  10  
       
Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
*/

// 13 ms 20%
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        leftBoundary(root.left,res);
        leaves(root.left,res);
        leaves(root.right,res);
        rightBoundary(root.right, res);
        return res;
    }
    public void leftBoundary(TreeNode root, List<Integer> res) {
        if(root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if(root.left != null){
            leftBoundary(root.left, res);  
        } else {
            leftBoundary(root.right, res);
        }
    }
    public void leaves(TreeNode root, List<Integer> res) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(root.val);   
            return;
        }
        leaves(root.left,res);
        leaves(root.right,res);
    }
    public void rightBoundary(TreeNode root, List<Integer> res) {
        if(root == null || (root.left == null && root.right == null)) return;
        if(root.right != null){
            rightBoundary(root.right, res);  
        } else {
            rightBoundary(root.left, res);
        }
        res.add(root.val);
    }
}

// improved one (combine together)
// 别人的 （我的在下面）
public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root!=null){
            ls.add(root.val);
            lookupElems(root.left,ls,true,false);      
            lookupElems(root.right,ls,false,true);
        }
        return ls;
    }
    
    private void lookupElems(TreeNode root,List<Integer> ls,boolean isLeftBoundary,boolean isRightBoundary){
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null) {
            ls.add(root.val);
            return;
        }        
        if (isLeftBoundary) {
            ls.add(root.val);
        } 
        lookupElems(root.left,ls,root.left!=null && isLeftBoundary,root.right==null && isRightBoundary);
        lookupElems(root.right,ls,root.left==null && isLeftBoundary,root.right!=null && isRightBoundary);
        if (isRightBoundary) {
            ls.add(root.val);
        }
    }
}

// mine~~
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root != null){
            res.add(root.val);
            combined(root, res, true, false);
            combined(root, res, false, true);
        }
        return res;
    }
    public void combined(TreeNode root, List<Integer> res, boolean left, boolean right) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(root.val);   
            return;
        }
        if(left) res.add(root.val);
        combined(root.left, res, root.left!=null && left, root.right==null&&right);
        combined(root.right, res, root.left==null&&left, root.right!=null&&right);
        if(right) res.add(root.val);
    } 
}