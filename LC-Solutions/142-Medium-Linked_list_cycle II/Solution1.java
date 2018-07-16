/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 15, 2017
 Problem:    linked list cycle II
 Difficulty: Medium
 Notes:

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if ((head==null )|| (head.next == null)) return null;
        ListNode chaser = head, runner = head;
        
        while(runner.next != null && runner.next.next !=null){
            runner = runner.next.next;
            chaser = chaser.next;
            if (runner == chaser) break;
        }
        if(runner.next== null || runner.next.next == null) return null;
        chaser = head;
        while(chaser != runner) {
            chaser = chaser.next;
            runner = runner.next;
        }
        return runner;
    }
}
