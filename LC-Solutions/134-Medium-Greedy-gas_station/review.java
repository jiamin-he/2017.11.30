/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 16, 2018
 Problem:    Gas Station
 Difficulty: Medium
 Notes:

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.


 */


// the amazing one.
// 0ms 100%
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int candidate = gas.length-1, total = gas[candidate]-cost[candidate], include = 0;
        while(candidate > include) {
            if(total < 0) {
                candidate--;
                total+= gas[candidate]-cost[candidate];
            } else {
                total += gas[include]-cost[include];
                include++;
            }
        }
        return total>=0? candidate:-1;
    }
}


// 0ms 100%
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, start = 0;
        for(int i = 0; i <= gas.length*2-1; i++){
            int index = i%gas.length;
            total+=gas[index]-cost[index];
            if(total < 0) {
				// imp*: it should be i+1, not index+1
                start = i+1;
                total = 0;
            }
        }
        return start>=gas.length?-1:start;
    }
}