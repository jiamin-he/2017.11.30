/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 16, 2017
 Problem:    merge k sorted lists
 Difficulty: Hard
 Notes:

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// priority queue
// for pq, insertion complexity is O(log k) (k is里面有多少个数)
// O(n log k)
// 26ms 14%
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.size(), (a,b) -> a.val - b.val);
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}


// 13ms 81%

// time: O(n log k)
// space: O(k)

// July 17th 2018 review
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
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for(int i = 0; i < lists.length; i++) {
            if(lists[i]!=null)pq.offer(lists[i]);
        }
        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
