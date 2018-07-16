/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 15, 2017
 Problem:    intersection of two linked lists
 Difficulty: Easy
 Notes:
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//默认了 尾巴相同 所以第二种方法是计算出长度 尾部对齐 然后一个个找
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aCur = headA, bCur = headB;
        while(aCur != bCur ) {
            aCur = aCur == null? headB:aCur.next;
            bCur = bCur == null? headA:bCur.next;
        }
        return aCur;
    }
}

// or by calculating length:
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // offset, move firstly
        // and then compare
    }
    
    public int length (ListNode head) {
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
