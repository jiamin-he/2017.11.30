/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 16, 2017
 Problem:    palindrome linked list
 Difficulty: easy
 Notes:
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?



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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode runner = head, chaser = head;
        while(runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            chaser = chaser.next;
        }
        chaser = reverse(chaser.next);
        runner = head;
        while(chaser != null) {
            if(runner.val != chaser.val) return false;
            runner = runner.next;
            chaser = chaser.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next; 
        }
        return prev;
    }
}
