/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 14, 2017
 Problem:    merge intervals
 Difficulty: Medium
 Notes:

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

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
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> res = new LinkedList<>();
        if(intervals.size() == 0 || intervals == null) return intervals;
        int endmax = intervals.get(0).end;
        int startpos = intervals.get(0).start;
        
        for(Interval i : intervals){
            if(endmax >= i.start){
                endmax = Math.max(endmax,i.end);
            } else {
                res.add(new Interval(startpos,endmax));
                startpos = i.start;
                endmax = i.end;
            }
        }
        
        res.add(new Interval(startpos, endmax));
        return res;
    }
}
