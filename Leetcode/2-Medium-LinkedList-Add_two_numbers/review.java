/*
Author: Jiamin
Date: Dec 17, 2017
Problem: Add two numbers

Example:
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Notes:
set carry, when not null, add, and then output.

*/


// iterative 
// 51ms 76%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode cur = dummy;
        
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        ListNode rem = l1 == null? l2:l1;
        while(rem != null) {
            int sum = rem.val + carry;
            rem.val = sum%10;
            carry = sum/10;
            cur.next = rem;
            cur = cur.next;
            rem = rem.next;
        }
        if(carry > 0) cur.next = new ListNode(carry);
        return dummy.next;
    }
}