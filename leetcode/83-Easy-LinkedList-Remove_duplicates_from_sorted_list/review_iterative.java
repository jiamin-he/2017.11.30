/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 08, 2018
 Problem:    remove duplicates from sorted list
 Difficulty: easy
 Notes:

Given a sorted linked list, delete all duplicates such that each element appear only once.

eg.
1 -> 1-> 2 return 1->2
1->1->2->3->3 return 1->2->3
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur!=null){
            while(cur.next!=null && cur.val == cur.next.val){
                cur = cur.next;
            }
            prev.next = cur;
            prev = cur;
            cur= cur.next;
        }
        return dummy.next;
    }
}