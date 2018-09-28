/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 21, 2018
 Problem:    Reorder List
 Difficulty: Medium
 Notes:

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/

// memory exceeded!!!
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        if(head == null) return;
        ListNode dummyH = head, dummyN = dummyH.next;
        while(dummyN!= null) {
            map.put(dummyN,dummyH);
            if(dummyN.next == null) {
                System.out.println(dummyN.val);
                helper(head, dummyN,map);
                System.out.println(head.val +" " + head.next.val +" ending...");
                return;
            } else {
                dummyH = dummyN;
                dummyN = dummyN.next; 
            }
            
        }
    }
    
    public ListNode helper(ListNode start, ListNode end, Map<ListNode, ListNode> map) {
        if(start == end || start.next == end) return start;
        System.out.println(start.val +" " +end.val);
        ListNode next = start.next;
        next = helper(next, map.get(end), map);
        System.out.println(next.val+" " +start.val + " " +end.val);
        start.next = end;
        end.next = next;
        return start;
    }
}

// 13ms 17%
class Solution {
    public void reorderList(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        if(head == null) return;
        ListNode dummyH = head, dummyN = dummyH.next;
        while(dummyN!= null) {
            map.put(dummyN,dummyH);
            if(dummyN.next == null) {
                helper(head, dummyN,map);
                return;
            } else {
                dummyH = dummyN;
                dummyN = dummyN.next; 
            }
            
        }
    }
    
    public ListNode helper(ListNode start, ListNode end, Map<ListNode, ListNode> map) {
        if(start == end || start.next == end) {
			// 有了这一句才不MLE！！！
            end.next = null;
            return start;   
        }
        ListNode next = start.next;
        next = helper(next, map.get(end), map);
        start.next = end;
        end.next = next;
        return start;
    }
}

// 5 ms 18%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummyH = head;
        while(dummyH!= null) {
            stack.push(dummyH);
            if(dummyH.next == null) {
                helper(head,stack);
                return;
            } else {
                dummyH = dummyH.next;
            }
            
        }
    }
    
    public ListNode helper(ListNode start,Deque<ListNode> stack) {
        if(start == stack.peek() || start.next == stack.peek()) {
            // 重点在这句！！！没有这句的话 他的后面还是原来那个数然后整个listnode就循环起来了 就memory limit exceeded了！！
			stack.peek().next = null;
            return start;   
        }
        ListNode next = start.next;
        ListNode end = stack.pop();
        start.next = end;
        end.next = helper(next, stack);
        return start;
    }
}

// I think this solution is still recursively!!!!