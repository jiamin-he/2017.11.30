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
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy, notNine = dummy;
        while(last.next != null) {
            last = last.next;
            if(last.val != 9) {
                notNine = last;
            }
        }
        if(last.val != 9) {
            last.val += 1;
        } else {
            notNine.val += 1;
            notNine = notNine.next;
            while(notNine != null) {
                notNine.val = 0;
                notNine = notNine.next;
            }
        }
        
        if(dummy.val == 0) return dummy.next;
        return dummy;
    }
}
