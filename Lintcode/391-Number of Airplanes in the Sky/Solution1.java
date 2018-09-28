/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 27, 2018
 Problem:    Number of Airplanes in the Sky
 Difficulty: Medium
 Notes:

Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

Example
For interval list

[
  (1,10),
  (2,3),
  (5,8),
  (4,7)
]
Return 3

*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
     
    private class Node {
        int val;
        int flag;
        
        public Node(int v, int f) {
            val = v;
            flag = f;
        }
    }
    
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if(airplanes.size() < 1) return 0;
        Node[] groups = new Node[airplanes.size() * 2];
        for (int i = 0; i < airplanes.size() ; i++) {
            groups[2 * i] = new Node(airplanes.get(i).start, 0);
            groups[2 * i + 1] = new Node(airplanes.get(i).end, 1);
        }
        Arrays.sort(groups, new Comparator<Node>(){
            public int compare (Node a, Node b) {
                if(a.val == b.val) {
                    return b.flag - a.flag; // "end" first.
                }
                return a.val - b.val;
            }
        });

        int count = 0 ,res = Integer.MIN_VALUE;
        for (int i = 0; i < groups.length; i++ ) {
            if(groups[i].flag == 0) {
                count++;
            } else {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}