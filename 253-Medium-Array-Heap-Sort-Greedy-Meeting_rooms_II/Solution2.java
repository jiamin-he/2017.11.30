/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 16, 2017
 Problem:    Meeting Rooms II
 Difficulty: Medium
 Notes:

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
*/

import java.util.*;

// class Interval {
//         int start;
//         int end;
//         Interval() { start = 0; end = 0; }
//         Interval(int s, int e) { start = s; end = e; }
//     }


class Solution2 {
    
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0 || intervals == null) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {return i1.start - i2.start;}
        });
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {return i1.end - i2.end;}
        });
        //PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        //Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++ ) {
            Interval event = heap.poll();
            if(intervals[i].start < event.end) {heap.offer(intervals[i]);}
            else {event.end = intervals[i].end;}
            heap.offer(event);
        }
        return heap.size();
    }
    
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        Interval[] i = new Interval[3];
        i[0] = new Interval(0,30);
        i[1] = new Interval(5,10);
        i[2] = new Interval(15,20);
        int res = s1.minMeetingRooms(i);

        System.out.println(res);
    }
}
