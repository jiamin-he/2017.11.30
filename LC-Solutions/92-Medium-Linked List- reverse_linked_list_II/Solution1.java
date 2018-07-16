/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 15, 2017
 Problem:    Reverse Linked List II
 Difficulty: medium
 Notes:

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode next = start.next; // prev=1 start=2 next=3 
        // prev 记录改变前的那一个 start记录起点 也是reverse后的最后一个
        // 所以prev 和 start绝对不可以被改变
        // next是记录每次被reverse的那个 所以值不断在更新
        // 记住每次专心只改变start的连接关系
        for(int i=0; i<n-m; i++) {
            start.next = next.next; // 2->4 // 2->5
            next.next = prev.next; // 3->2 // 4->3
            prev.next = next; // 1->3 // 1->4
            next = start.next; // next = 4 prev = 1 start = 2 (1->3->2->4) // next = 5 prev = 1 start = 2 (1->4->3->2->5)
        }
        return dummy.next;
    }
}
