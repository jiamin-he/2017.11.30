/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 15, 2017
 Problem:    rotate list
 Difficulty: Medium
 Notes:

Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.


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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        int len = 0;
        while(runner.next != null) {
            len++;
            runner = runner.next;
        }
        runner.next = head;
        k = k % len;
        k = len - k ;
        while(runner.next != null && k > 0) {
            runner = runner.next;
            k--;
        }
        dummy.next = runner.next;
        runner.next = null;
        return dummy.next;
    }
}
