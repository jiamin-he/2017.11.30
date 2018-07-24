/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 21st, 2018
 Problem:    linked list cycle
 Difficulty: Easy
 Notes:

Given a linked list, determine if it has a cycle in it.

Follow up:
can you solve it without using extra space?

*/


// 0ms 100%
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        if(head == null) return false;
        while(fast.next!=null && fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }
}