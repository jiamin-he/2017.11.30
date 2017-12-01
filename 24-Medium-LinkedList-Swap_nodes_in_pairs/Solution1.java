/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 19, 2017
 Problem:    swap nodes in pairs
 Difficulty: Easy
 Notes:

GGiven a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


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

    public static ListNode swapPairs1 (ListNode head){
      if (head==null ) {
        return head;
      }

      ListNode newHead = new ListNode(-1);
      newHead.next =head;
      ListNode cur = newHead;
      while(cur.next!=null && cur.next.next!=null){
        ListNode first = cur.next;
        ListNode second = cur.next.next;

        //swap
        cur.next=second;
        first.next = second.next;
        second.next = first;

        //iterate
        cur = cur.next.next;
      }

      return newHead.next;

    }

    public static ListNode swapPairs2 (ListNode head){
      if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);


        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;


        System.out.println("list: ");
        print(head);

        System.out.println("swap 1 : ");
        print(swapPairs1(head)); //注意 这时head已经排成第二个了 所以下面继续对head进行swap的时候是从第二个开始的

        System.out.println("swap 2 : ");
        print(swapPairs2(head));



        



    }
}
