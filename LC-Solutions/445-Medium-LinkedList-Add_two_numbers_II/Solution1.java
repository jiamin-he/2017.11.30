/*
Author: Jiamin
Date: Dec 17, 2017
Problem: Add two numbers II

Example:
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 59ms 65%
// stack
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        int sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();
            dummy.val = sum%10;
            sum /= 10;
            ListNode cur = new ListNode(sum);
            cur.next = dummy;
            dummy = cur;
        }
        return dummy.val == 0? dummy.next: dummy;
    }
}


// reverse list and then calculate
//
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
        l1 = reverseListNodes(l1);
        l2 = reverseListNodes(l2);
        ListNode head = addTwoNumbersSimple(l1,l2);
        head = reverseListNodes(head);
        return head;
    }
    public ListNode reverseListNodes(ListNode head) {
        ListNode prev = null, cur = null;
        while(head != null) {
            cur = head.next;
            head.next = prev;
            prev = head;
            head = cur;
        }
        return prev;
    }
    public ListNode addTwoNumbersSimple(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while(l1 != null && l2 != null) {
            sum += l1.val + l2.val;
            ListNode next = new ListNode(sum%10);
            sum = sum/10;
            cur.next = next;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode rem = l1 == null? l2:l1;
        while(rem != null) {
            sum += rem.val;
            ListNode next = new ListNode(sum%10);
            sum = sum/10;
            cur.next = next;
            cur = cur.next;
            rem = rem.next;
        }
        if(sum > 0) cur.next = new ListNode(sum);
        return dummy.next;
    }
}

