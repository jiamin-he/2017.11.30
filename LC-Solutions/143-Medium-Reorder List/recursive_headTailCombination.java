/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 21, 2018
 Problem:    Reorder List
 Difficulty: Medium
 Notes:

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/

// 2ms 99%
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        // find the middle 
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // reverse the right part
        ListNode tail = null;
        ListNode right = slow.next;
        slow.next = null;
        while(right!=null) {
            ListNode next = right.next;
            right.next = tail;
            tail = right;
            right = next;
        }
        // conquer two parts
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(head != null) {
            cur.next = head;
            head = head.next;
            cur.next.next = tail;
            cur = cur.next.next;
            tail = tail==null?null:tail.next;
        }
        
        head = dummy.next;
    }
}