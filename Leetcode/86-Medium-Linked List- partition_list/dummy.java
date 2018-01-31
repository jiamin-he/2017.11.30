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

// Jan 25th review
// same solution
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(0);
        ListNode dummyGE = new ListNode(0);
        ListNode curL = dummyL;
        ListNode curGE = dummyGE;
        while(head != null) {
            if(head.val < x) {
                curL.next = head;
                curL = curL.next;
            } else {
                curGE.next = head;
                curGE = curGE.next;
            }
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        curL.next = dummyGE.next;
        return dummyL.next;
    }
}
