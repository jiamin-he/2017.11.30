/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 17, 2017
 Problem:    Plus One Linked List
 Difficulty: medium
 Notes:

Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4


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
    public ListNode plusOne(ListNode head) {
        int carry = helper(head);
        if( carry== 0) return head;
        ListNode dummy = new ListNode(carry);
        dummy.next = head;
        return dummy;
    }
    
    public int helper(ListNode head) {
        if(head == null) return 1;
        int carry = helper(head.next);
        if(carry == 0) return 0;
        int val = head.val + carry;
        head.val = val%10;
        return val/10;
    }
}
