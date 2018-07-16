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

class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


class Solution1 {
    
    public int minMeetingRooms(Interval[] intervals) {
        int length = intervals.length;
        int[] start = new int[length];
        int[] end = new int[length];
        for (int i = 0; i < length ; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0, endIndex = 0;
        for (int i = 0; i < length ; i++ ) {
            if (start[i] < end[endIndex]) rooms++;
            else endIndex++;
        }
        return rooms;
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
