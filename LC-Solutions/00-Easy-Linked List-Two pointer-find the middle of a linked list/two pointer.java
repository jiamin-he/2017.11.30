/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 15, 2017
 Problem:    Find the middle of a Linked List
 Difficulty: easy
 Notes:

Given a linked list and a value x, write a function to return the middle point of that list.


*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middle(ListNode head) {
        ListNode runner = head, chaser = head;
        if (head == null) return head;
        while (runner.next != null && runner.next.next != null) {
            chaser = chaser.next;
            runner = runner.next.next;
        }
        return chaser;
    }
}
