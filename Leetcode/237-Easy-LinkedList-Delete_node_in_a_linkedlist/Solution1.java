/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 18, 2017
 Problem:    delete node in a linked list
 Difficulty: Easy
 Notes:
Delete a node (except the tail) in a singly linked list, given only access to that code.
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

    public static void deleteNode(ListNode node){
        
        node.val = node.next.val;
        node.next = node.next.next;
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

        deleteNode(second);
        System.out.println("deleted list: ");
        print(head);



    }
}
