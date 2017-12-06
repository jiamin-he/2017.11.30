/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 20, 2017
 Problem:    palindrome linked list
 Difficulty: Easy
 Notes:

Given a singly linked list, determine if it is a palindrome.

Follow up:
can you do it in o(n) time and o(1) space?

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

    public static boolean isPalindrome1 (ListNode head){
        ListNode newHead = head;
        while(newHead!= null && newHead.next!=null){
          newHead = newHead.next;
        }

    }

  

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);


        head.next = first;
        first.next = second;
        second.next = third;
        third.next = first;

        //System.out.println("list: ");
        //print(head);

        System.out.println("is palindrome 1 ? " );
        boolean result1 = isPalindrome1(head);
        System.out.println(result1);

        



    }
}
