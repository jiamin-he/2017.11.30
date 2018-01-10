/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    employee free time
 Difficulty: hard
 Notes:

We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

Example 1:
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)

Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

Note:

schedule and schedule[i] are lists with lengths in range [1, 50].
0 <= schedule[i].start < schedule[i].end <= 10^8.

*/

// TLE 
// 24000000,2499999... 之类的interval 就要走很久 慢

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int maxTime = 0;
        for(List<Interval> s: schedule) {
            maxTime = Math.max(s.get(s.size()-1).end, maxTime);
        }
        boolean[] busy = new boolean[maxTime];
        
        for(List<Interval> s:schedule) {
            for(Interval i: s) {
                int len = i.end-i.start;t
                for(int j = 0; j < len; j++) {
                    busy[i.start + j] = true;
                }
            }
        }
        
        List<Interval> res = new ArrayList<>();
        for(int i =0; i < maxTime; i++) {
            int iStart = i;
            while(busy[i] == false) i++;
            if(i!=iStart) res.add(new Interval(iStart,i));
        }
        if(res.get(0).start == 0) res.remove(0);
        return res;
    }
}


// 31ms
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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> oneSchedule = new ArrayList<>();
        for(List<Interval> s : schedule) {
            oneSchedule.addAll(s);
        }
        Collections.sort(oneSchedule, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if(a.start > b.start) return 1;
                else if(a.start < b.start) return -1;
                else return a.end - b.end;
            }
        });
        
        List<Interval> res1 = new ArrayList<>();
        //Interval prev = oneSchedule.get(0); 不能用这个 因为传过去的是object 直接传引用 这样后面再用res1的时候就不对了
        int start = oneSchedule.get(0).start;
        int end = oneSchedule.get(0).end;
        for(Interval i: oneSchedule) {
            if(end < i.start) {
                res1.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            } else {
                end = Math.max(i.end, end);
            }
        }
        res1.add(new Interval(start,end));
        
        List<Interval> res2 = new ArrayList<>();
        for(int i = 0; i < res1.size()-1; i++) {
            res2.add(new Interval(res1.get(i).end, res1.get(i+1).start));
        }
        return res2;
    }
}


// 直接不merge 直接取也可以
// 快一点点 
// 29ms
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> oneSchedule = new ArrayList<>();
        for(List<Interval> s : schedule) {
            oneSchedule.addAll(s);
        }
        Collections.sort(oneSchedule, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if(a.start > b.start) return 1;
                else if(a.start < b.start) return -1;
                else return a.end - b.end;
            }
        });
        
        List<Interval> res = new ArrayList<>();
        int start = oneSchedule.get(0).end;
        for(Interval i: oneSchedule) {
            if(start >= i.start) {
                start = Math.max(start,i.end);
            } else {
                res.add(new Interval(start, i.start));
                start = i.end;
            }
        }
        
        return res;
    }
}