/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 19, 2017
 Problem:    remove linked list elements
 Difficulty: Easy
 Notes:

remove all elements from a linked list of inteers that have value val.


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

    public static ListNode removeElements1 (ListNode head, int val){
      if (head == null) {
        return null;
      }
      head.next = removeElements1(head.next, val);
      return head.val == val ? head.next: head;
    }

    public static ListNode removeElements2 (ListNode head, int val){
      if (head == null) {
        return null;
      }
      
      ListNode newHead = new ListNode(-1);
      newHead.next = head;

      ListNode prev = newHead, cur = head;

      while(cur!=null){
      if (cur.val == val) {
        prev.next = cur.next;
        cur = cur.next;
      } else{
        prev = prev.next;
        cur=cur.next;
      }
    }

      return newHead.next;
    }

    public static ListNode removeElements3 (ListNode head, int val){
      if (head == null) {
        return null;
      }
      
      ListNode cur = head;
      while(cur.next !=null){
        if (cur.next.val == val) {
          cur.next = cur.next.next;
        } else {
          cur = cur.next; 
        }

      }

      

      if (head.val == val) {
        return head.next;
      }
      return head;
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
        System.out.println("removed list 1 : ");
        print(removeElements1(head,0)); //方法1 对于第一个数 只是返回了head.next 并没有把头一个真正删除掉，所以使用head依然可以访问到头节点
        System.out.println("removed list 2 : ");
        print(removeElements1(head,1));  //证明方法1没有改变头节点，但此时中间被删除的节点已经没有人指向他了，会进入垃圾空间被删除
        
        //所以从这里开始 head的完全列表是 0 2 3
        System.out.println("removed list 3 : ");
        print(removeElements2(head,0));  //不改变头 因为头依然有名字 但中间的已被扔 回不来了

        // 0 2 3
        System.out.println("list 4 : ");
        print(head); // 证明是 0 2 3


        System.out.println("removed list 5 : ");
        print(removeElements2(head,3));  //不改变头 因为头依然有名字 但中间的已被扔 回不来了

        //0  2
        System.out.println("removed list 6 : ");
        print(removeElements3(head,2)); 
        

        



    }
}
