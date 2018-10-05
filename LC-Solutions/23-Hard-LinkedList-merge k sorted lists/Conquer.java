/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 16, 2017
 Problem:    merge k sorted lists
 Difficulty: Hard
 Notes:

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

*/

// 思路启发 由 merge two lists 思考过来 两两结合 再继续两两结合 相当于树从底层到顶层
// for example, 8 ListNode, and the length of every ListNode is x1, x2,
// x3, x4, x5, x6, x7, x8, total is n.

// on level 3: x1+x2, x3+x4, x5+x6, x7+x8 sum: n

// on level 2: x1+x2+x3+x4, x5+x6+x7+x8 sum: n

// on level 1: x1+x2+x3+x4+x5+x6+x7+x8 sum: n

// total 3n, nlog8

// O(n log k)
// space O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode [] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }

        if(start < end) {
            int mid = start + (end - start) / 2;

            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);

            return mergeTwoLists(l1, l2);
        }
        return null;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2 == null) return l1;
        if(l1 == null) return l2;

        if(l1.val < l2.val) {
            ListNode temp = l1;
            temp.next = mergeTwoLists(l1.next, l2);
            return temp;
        } else {
            ListNode temp = l2;
            temp.next = mergeTwoLists(l1, l2.next);
            return temp;
        }
    }
}


// Sep 23rd 2018 review
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1) return null;
        return mergeK(lists, 0, lists.length - 1);
    }
    
    public ListNode mergeK (ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        } else if (left + 1 < right) {
            int mid = left + (right - left) / 2;
            ListNode l1 = mergeK(lists, left, mid);
            ListNode l2 = mergeK(lists, mid + 1, right);
            return mergeTwo(l1, l2);
        } else {
            return mergeTwo(lists[left], lists[right]);
        }
    }
    
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
         
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if( l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        
        return dummy.next;
    }
}