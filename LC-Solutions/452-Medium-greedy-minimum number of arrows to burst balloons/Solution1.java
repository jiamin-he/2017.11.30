/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    Minimum Number of Arrows to Burst Balloons
 Difficulty: medium
 Notes:
There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).


*/


// 78ms 55%
class Solution {
    class Interval {
        int value;
        int index;
        Interval(int v, int i) {
            value = v;
            index = i;
        }
    }
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        Interval[] start = new Interval[len];
        Interval[] end = new Interval[len];
        boolean[] shot = new boolean[len];
        for(int i = 0; i < len; i++) {
            start[i] = new Interval(points[i][0], i);
            end[i] = new Interval(points[i][1], i);
        }
        Arrays.sort(start, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.value - b.value;
            }
        });
        Arrays.sort(end, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.value - b.value;
            }
        });
        int count = 0;
        for(int i = 0, j = 0; i < len && j < len; j++) {
            int iStart = i;
            if(shot[end[j].index]) continue;
            while(i < len && start[i].value <= end[j].value) {
                shot[start[i].index] = true;
                i++;  
            } 
            count += iStart == i? 0:1;
        }
        return count;
    }
}