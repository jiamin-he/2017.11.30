/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 17, 2017
 Problem:    swap nodes in pairs
 Difficulty: Easy
 Notes:

GGiven a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode node1 = head, node2 = null;
        while(node1 != null && node1.next != null) {
            node2 = node1.next;
            prev.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            prev = node1;
            node1 = node1.next;
        }
        return dummy.next;
    }
}
