/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 18, 2017
 Problem:    linked list cycle
 Difficulty: Easy
 Notes:

Given a linked list, determine if it has a cycle in it.

Follow up:
can you solve it without using extra space?

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

    public static boolean hasCycle1(ListNode head){
      if ((head==null )|| (head.next == null)) {
        return false;
      }
      if (head.next == head) {
        return true;
      }

      ListNode nextNode = head.next;
      head.next  = head;
      boolean isCycle = hasCycle1(nextNode);
      return isCycle;
    }

    public static boolean hasCycle2(ListNode head){
      if ((head==null )|| (head.next == null)) {
        return false;
      }
      if (head.next == head) {
        return true;
      }

      ListNode runner = head;
      ListNode walker = head;

      while(runner.next != null || runner.next.next !=null){
        runner = runner.next.next;
        walker = walker.next;

        if (runner == walker) {
          return true;
        }
      }

      return false;
    }

    public static boolean hasCycle3(ListNode head){
      if ((head==null )|| (head.next == null)) {
        return false;
      }
      if (head.next == head) {
        return true;
      }
      
      HashSet<ListNode> set = new HashSet<>();
      while(head!=null){
        if (set.contains(head)) {
          return true;
        } else {
          set.add(head);
        }

        head = head.next;


      }


      return false;
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

        System.out.println("is cycle 1 ? " );
        boolean result1 = hasCycle1(head);
        System.out.println(result1);

        System.out.println("is cycle 2 ? " );
        boolean result2 = hasCycle2(head);
        System.out.println(result2);

        System.out.println("is cycle 3 ? " );
        boolean result3 = hasCycle3(head);
        System.out.println(result3);



    }
}
