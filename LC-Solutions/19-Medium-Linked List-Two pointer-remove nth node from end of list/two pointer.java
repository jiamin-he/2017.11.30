/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 15, 2017
 Problem:    Remove Nth Node From End of List
 Difficulty: medium
 Notes:

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner = head, chaser = head;
        if(head == null || n < 0) return null;
        for (int i = 0; i < n; i++) {
            runner = runner.next;
            if(runner == null && i != n-1) return head;
        }
        if(runner == null) return head.next;
        while(runner.next != null) {
            chaser = chaser.next;
            runner = runner.next;
        }
        chaser.next = chaser.next.next;
        return head;
    }
}


// 另一种写法 加上dummy
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy, chaser = dummy;
        dummy.next = head;
        while(runner.next != null && n > 0) {
            runner = runner.next;
            n--;
        }
        while(runner.next != null) {
            chaser = chaser.next;
            runner = runner.next;
        }
        chaser.next = chaser.next.next;
        return dummy.next;
    }
}


// Jan 25th 2018 review
// dummy node and two pointers 
// one pass, O(N)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(n-- > 0 && fast != null) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next.next;
        slow.next = temp;
        return dummy.next;
    }
}