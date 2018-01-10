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
// 17ms
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if( intervals == null || intervals.size() == 0) return intervals;
        int size = intervals.size();
        int[] start = new int[size];
        int[] end = new int[size];
        for (int i = 0; i < size; i++){
            Interval temp = intervals.get(i);
            start[i] = temp.start;
            end[i] = temp.end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> res = new LinkedList<>();
        for(int i = 0, j = 0; i < size; i++){
            if((i == size - 1) || start[i+1] > end[i]){
                res.add(new Interval(start[j],end[i]));
                j = i+1;
            }
        }
        return res;
    }
}