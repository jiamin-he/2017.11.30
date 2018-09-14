/*
Author: Jiamin
Date: Sep 9, 2018
Problem:  Exam Room
Difficulty: Medium

In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)

Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.

 

Example 1:

Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
Output: [null,0,9,4,2,null,5]
Explanation:
ExamRoom(10) -> null
seat() -> 0, no one is in the room, then the student sits at seat number 0.
seat() -> 9, the student sits at the last seat number 9.
seat() -> 4, the student sits at the last seat number 4.
seat() -> 2, the student sits at the last seat number 2.
leave(4) -> null
seat() -> 5, the student​​​​​​​ sits at the last seat number 5.
​​​​​​​

Note:

1 <= N <= 10^9
ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 
*/

// 209ms 6%
// remove O(log N)
// insert O(N) + O(log N) = O(N)
class ExamRoom {
    
    Node head;
    Map<Integer, Node> map;
    int max;

    public ExamRoom(int N) {
        head = new Node(0);
        map = new HashMap<>();
        max = N;
    }
    
    public int seat() {
        if(map.size() == 0){
            Node n = new Node(0);
            head.next = n;
            n.pre = head;
            map.put(0, n);
            
            return 0;
            
        }else{
            
            Node n = head.next;
            
            int interval = 0;
            Node res = n;
            
            if(n.val > interval){
                interval = n.val;
                res = head;
            } 
        
            while(n.next != null){
                if((n.next.val - n.val) / 2 > interval){
                    interval = (n.next.val - n.val) / 2;
                    res = n;
                } 
                //System.out.println("interval "+interval);
                n = n.next;
            }
            if(max - 1 - n.val > interval){
                interval = max - 1 - n.val;
                res = n;
            } 
            
            Node node = res == head ? new Node(0) : new Node(res.val + interval);
            
            node.pre = res;
            if(res.next != null){
                node.next = res.next;
                res.next.pre = node;
            }
            res.next = node;
            
            map.put(node.val, node);
            //System.out.println("res " + node.val);
            return node.val;
        }
        
    }
    
    public void leave(int p) {
        Node n = map.remove(p);
        n.pre.next = n.next;
        if(n.next != null){
            n.next.pre = n.pre;
        }
    }
}

class Node{
    int val;
    Node next;
    Node pre;
    
    Node(int v){
       this.val = v; 
    }  
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */