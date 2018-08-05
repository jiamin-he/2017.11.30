/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 4th, 2018
 Problem:    Copy List with Random Pointer
 Difficulty: medium
 Notes:
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

*/

// 4ms 25%
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<Integer, RandomListNode> map = new HashMap<>();
        if(head == null) return null;
        RandomListNode cloneHead = new RandomListNode(head.label);
        RandomListNode cloneHeadCopy = cloneHead;
        map.put(head.label, cloneHead);
        while(head != null) {
            
            if(head.next != null){
                if(!map.containsKey(head.next.label)) {
                   map.put(head.next.label, new RandomListNode(head.next.label));
                }
                cloneHead.next = map.get(head.next.label);
            }
            
            if(head.random != null){
                if(!map.containsKey(head.random.label)) {
                   map.put(head.random.label, new RandomListNode(head.random.label));
                }
                cloneHead.random = map.get(head.random.label);
            }
            head = head.next;
            cloneHead = cloneHead.next;
        }
        return cloneHeadCopy;
    }
}


// 1ms 100%
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // corner case
        if(head == null) return null;
        
        // 首先遍历一遍，在每个ListNode后面加一个copy
        RandomListNode pointer = head;
        while(pointer != null){
            RandomListNode copy = new RandomListNode(pointer.label);
            copy.next = pointer.next;
            pointer.next = copy;
            pointer = pointer.next.next;
        }
        
        // 然后遍历一遍，解决Random的指向问题
        RandomListNode cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;   
            }
            cur = cur.next.next;
        }
        
        // 最后遍历一遍，只留copyNode的指向，extract出来，然后返回结果
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode p = dummy;
        cur = head;
        while(cur != null){
            p.next = cur.next;
            cur.next = cur.next.next;
            // 更新p
            p = p.next;
            // 更新cur
            cur = cur.next;
        }
        
        // return 
        return dummy.next;
    }
}