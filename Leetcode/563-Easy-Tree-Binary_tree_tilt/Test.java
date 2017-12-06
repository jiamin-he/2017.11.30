/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 26, 2017
 Problem:    binary tree tilt
 Difficulty: Easy
 Notes:

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

eg

Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1


*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import solution;

class Test {

    public static void main(String[] args) {
        Solution1 s1=new Solution1();
        System.out.println(s1.result);
        Solution1.result++;
        Solution1 s2=new Solution1();
        System.out.println(s2.result);



    }
}
