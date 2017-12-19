/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 15, 2017
 Problem:    Partition List
 Difficulty: medium
 Notes:

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.


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
    public ListNode partition(ListNode head, int x) {
        ListNode aDummy = new ListNode(0);
        ListNode bDummy = new ListNode(0);
        ListNode aCur = aDummy, bCur = bDummy;
        
        while(head != null) {
            ListNode next = head.next;
            head.next = null;
            if(head.val < x) {
                aCur.next = head;
                aCur = head;
            } else {
                bCur.next = head;
                bCur = head;
            }
            head = next;
        }
        aCur.next = bDummy.next;
        return aDummy.next;
    }
}
