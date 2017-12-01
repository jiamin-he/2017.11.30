/*
Author: Jiamin
Date: Sep 16, 2017
Problem: Add two numbers

Example:
 
 You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 
 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 
 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 
 Example:
 
 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7

 
 Notes:
set carry, when not null, add, and then output.

*/


// my work--not ok now. need to be improved.

class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse (l1);
        l2 = reverse (l2);
        
        return reverse(addBasic(l1,l2));
        
        
    }
    
    public ListNode addBasic (ListNode l1, ListNode l2) {
        ListNode newHead =  new ListNode (0);
        ListNode resultHead = newHead;
        int carry = 0;
        
        while(l1!=null || l2!= null || carry >0) {
            carry += ((l1==null) ? 0: l1.val ) +((l1==null) ? 0: l1.val );
            newHead.next = new ListNode(carry % 10);
            
            System.out.print(newHead.next.val);
            
            carry = carry /10;
            newHead = newHead.next;
            
            l1 = (l1==null) ? l1: l1.next;
            l2 = (l2==null) ? l2: l2.next;
            
        }
        
        return resultHead.next;
        
    }
    
    
    public ListNode reverse (ListNode head) {
        ListNode prev = null;
        while( head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            
            System.out.print(prev.val);
        }
        
        return prev;
    }
}
