/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    Non-overlapping Intervals
 Difficulty: medium
 Notes:
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// 14ms 36%
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int len = intervals.length;
        Interval[] start = new Interval[len];
        Interval[] end = new Interval[len];
        boolean[] remove = new boolean[len];
        for(int i = 0; i < len; i++) {
            start[i] = new Interval(intervals[i].start, i);
            end[i] = new Interval(intervals[i].end, i);
        }
        Arrays.sort(start, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Arrays.sort(end, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int count = 0;
        for(int i = 0, j = 0; i < len && j < len; j++) {
            if(remove[end[j].end]) continue;
            int iStart = i, minEnd = Integer.MAX_VALUE, endI = 0;
            while(i < len && j < len && start[i].start < end[j].start) {
                remove[start[i].end] = true;
                if(intervals[start[i].end].end < minEnd) {
                    minEnd = intervals[start[i].end].end;
                    endI = start[i].end;
                }
                i++;
            } 
            remove[endI] = false;
            count += i-iStart-1;
        }
        return count;
    }
}