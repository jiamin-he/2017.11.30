/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 19, 2017
 Problem:    merge two sorted lists
 Difficulty: Easy
 Notes:

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution1 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void print(ListNode head){
      //只能print没有循环的！有循环的他就退不出来了！！！
        ListNode cur = head;
        while (cur!=null){
            System.out.print(cur.val +" ");
            cur=cur.next;
        }
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if ( l1 ==null ) {
            return l2;
        } 
        if (l2 == null ) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l2.next, l1);
            return l2;
        }

    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if ( l1 ==null ) {
            return l2;
        } 
        if (l2 == null ) {
            return l1;
        }

        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;

        while (l1 !=null && l2!=null){
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;

            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;

        }

        if (l1 == null) {
            prev.next = l2;
        }

        if (l2 == null) {
            prev.next = l1;
        }

        return newHead.next;
    }
    
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = l1.val < l2.val ? l1:l2;
        ListNode nonHead = l1.val < l2.val ? l2: l1;

        newHead.next = mergeTwoLists3(newHead.next, nonHead);
        return newHead;

    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode first1 = new ListNode(2);
        ListNode second1 = new ListNode(3);
        ListNode third1 = new ListNode(7);
        ListNode fourth1 = new ListNode(9);


        head1.next = first1;
        first1.next = second1;
        second1.next = third1;
        third1.next = fourth1;

        ListNode head2 = new ListNode(2);
        ListNode first2 = new ListNode(3);
        ListNode second2 = new ListNode(6);
        ListNode third2 = new ListNode(8);
        ListNode fourth2 = new ListNode(9);


        head2.next = first2;
        first2.next = second2;
        second2.next = third2;
        third2.next = fourth2;


        System.out.println("list 1 : ");
        print(head1);

        System.out.println("list 2 : ");
        print(head2);

        // System.out.println("merge 1 : ");
        // print(mergeTwoLists1(head1,head2));

        // System.out.println("merge 2 : ");
        // print(mergeTwoLists2(head2,head1));

        System.out.println("merge 3 : ");
        print(mergeTwoLists3(head2,head1));


        
    }
}
