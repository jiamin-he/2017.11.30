/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 16, 2017
 Problem:    Meeting Rooms
 Difficulty: Easy
 Notes:

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

*/

import java.util.*;

class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


class Solution1 {
    
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0 || intervals == null ) return true;
        Arrays.sort( intervals, new Comparator<Interval>(){
            public int compare (Interval i1, Interval i2){
                return i1.start - i2.start;
            }});
        for (int i = 0; i < intervals.length - 1; i++)
            if (intervals[i+1].start < intervals[i].end) return false;
        return true;
    }
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        Interval[] i = new Interval[3];
        i[0] = new Interval(0,30);
        i[1] = new Interval(5,10);
        i[2] = new Interval(15,20);
        boolean res = s1.canAttendMeetings(i);

        System.out.println(res);
    }
}
