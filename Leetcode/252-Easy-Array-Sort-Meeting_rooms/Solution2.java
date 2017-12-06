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

// class Interval {
//         int start;
//         int end;
//         Interval() { start = 0; end = 0; }
//         Interval(int s, int e) { start = s; end = e; }
//     }


class Solution2 {
    
    public boolean canAttendMeetings(Interval[] intervals) {
        int length = intervals.length;
        int[] start = new int[length];
        int[] end = new int[length];
        for (int i = 0; i < length ; i++ ) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < length - 1 ; i++ ) {
            if (start[i+1]<end[i]) return false;
        }
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
