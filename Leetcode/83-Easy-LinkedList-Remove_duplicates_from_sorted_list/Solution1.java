/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 19, 2017
 Problem:    remove duplicates from sorted list
 Difficulty: Easy
 Notes:

Given a sorted linked list, delete all duplicates such that each element appear only once.

eg.
1 -> 1-> 2 return 1->2
1->1->2->3->3 return 1->2->3

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

    public static ListNode deleteDuplicates1(ListNode head){
      ListNode newHead = head;

      while(newHead!=null){
        if (newHead.next ==null) {
          break;
        } else if (newHead.val == newHead.next.val) {
          newHead.next = newHead.next.next;
        } else{
          newHead = newHead.next;
        }

      }

      return head;
    }

    public static ListNode deleteDuplicates2(ListNode head){
      if (head == null || head.next == null) {
        return head;
      }
      head.next = deleteDuplicates2(head.next);
      return head.next.val == head.val ? head.next: head;
    }

    

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(1);


        head.next = first;
        first.next = second;
        second.next = third;
        

        System.out.println("list: ");
        print(head);
        // System.out.println("removed duplicate list 1 : ");
        // print(deleteDuplicates1(head));
        System.out.println("removed duplicate list 2 : ");
        print(deleteDuplicates2(head));

        



    }
}
