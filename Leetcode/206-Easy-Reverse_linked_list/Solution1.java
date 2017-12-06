/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 17, 2017
 Problem:    Reverse Linked List
 Difficulty: Easy
 Notes:

Reverse a singly linked list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution1 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void print(ListNode head){
        ListNode cur = head;
        while (cur!=null){
            System.out.print(cur.val +" ");
            cur=cur.next;
        }
    }

    public static ListNode reverseList1(ListNode head) {
        
        if (head == null || head.next == null) {
          return head;
        }

        ListNode nextNode = head.next;
        ListNode newNode = reverseList1(nextNode);

        nextNode.next = head;
        head.next = null;
        return newNode;
    }

    public static ListNode reverseList2(ListNode head){
      if (head == null) {
        return null;
      }

      ListNode newHead = null;
      ListNode cur = head;
      while(cur!=null){
        ListNode nextNode = cur.next;

        if (newHead == null) {
         newHead = cur;
         newHead.next = null; 
        } else {
          cur.next = newHead;
          newHead = cur;
        }

        cur = nextNode;
      }

      return newHead;
    }

    public static ListNode reverseList3(ListNode head){
      if (head == null) {
        return null;
      }

      ListNode newHead = null;
      
      while(head!=null){
        ListNode nextNode = head.next;

        head.next = newHead;
        newHead = head;
        head = nextNode;
      }

      return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);


        head.next = first;
        first.next = second;
        second.next = third;

        System.out.println("list: ");
        print(head);

        System.out.println( "\n" + "list reversed 1 : ");
        ListNode reverse1 = reverseList1(head);
        print(reverse1);
        System.out.println( "\n" + "head had been changed: ");
        print(head);

        System.out.println("\n" + "list reversed 2 : ");
        ListNode reverse2 = reverseList2(reverse1);
        print(reverse2);
        System.out.println( "\n" + "head had been changed: ");
        print(reverse1);

        System.out.println("\n" + "list reversed 3 : ");
        ListNode reverse3 = reverseList3(reverse2);
        print(reverse3);
        System.out.println( "\n" + "head had been changed: ");
        print(reverse2);



    }
}
