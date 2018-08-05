/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 14, 2017
 Problem:    Binary Tree Vertical Order Traversal
 Difficulty: Medium
 Notes:
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]

*/

// 4ms 82%
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) return rst;
        List<Integer> zeroCol = new ArrayList<>();
        rst.add(zeroCol);
        int minCol = 0; //use minCol and maxCol to help insert List at right position (no need for map)
        int maxCol = 0;

        Queue<TreeNode> level = new LinkedList<TreeNode>();
        Queue<Integer> levelCol = new LinkedList<Integer>();
        level.add(root);
        levelCol.add(0);

        while(!level.isEmpty() && !levelCol.isEmpty()) {
            TreeNode curr = level.poll();
            int currCol = levelCol.poll();

            if (currCol < minCol) { //create new List when new column found
                List<Integer> newCol = new ArrayList<>();
                newCol.add(curr.val);
                rst.add(0, newCol); //new leftmost column
                minCol = currCol;
            } else if (currCol > maxCol) {
                List<Integer> newCol = new ArrayList<>();
                newCol.add(curr.val); // new rightmost column
                rst.add(maxCol - minCol + 1, newCol);
                maxCol = currCol;
            } else {
                rst.get(currCol - minCol).add(curr.val);
            }

            if (curr.left != null) {
                level.add(curr.left);
                levelCol.add(currCol - 1);
            }

            if (curr.right != null) {
                level.add(curr.right);
                levelCol.add(currCol + 1);
            }
        }

        return rst;
    }
}


// 2ms 98%
// no need to set a hashmap to store the mapping of the integer(index) and the corresponding arraylist.
// only need to record the offset.
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> indices = new LinkedList<>();
        int offset = 0;
        if(root == null) return res;
        res.add(new ArrayList<Integer>());
        q.offer(root);
        indices.offer(0);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            int index = indices.poll();
            if((index+offset) < 0) {
                res.add(0, new ArrayList<Integer>());
                offset++;
            } else if ((index+offset) >= res.size()) {
                res.add(new ArrayList<Integer>());
            }
            res.get(index+offset).add(temp.val);
            if(temp.left != null) {
                q.offer(temp.left);
                indices.offer(index-1);
            }
            if(temp.right != null) {
                q.offer(temp.right);
                indices.offer(index+1);
            }
        }
        return res;
    }
}