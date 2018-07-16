/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 25, 2017
 Problem:    exclusive time of functions
 Difficulty: Medium
 Notes:

Given the running logs of n functions that are executed in a nonpreemptive single threaded CPU, find the exclusive time of these functions.

Each function has a unique id, start from 0 to n-1. A function may be called recursively or by another function.

A log is a string has this format : function_id:start_or_end:timestamp. For example, "0:start:0" means function 0 starts from the very beginning of time 0. "0:end:0" means function 0 ends to the very end of time 0.

Exclusive time of a function is defined as the time spent within this function, the time spent by calling other functions should not be considered as this function's exclusive time. You should return the exclusive time of each function sorted by their function id.

Example 1:
Input:
n = 2
logs = 
["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
Output:[3, 4]
Explanation:
Function 0 starts at time 0, then it executes 2 units of time and reaches the end of time 1. 
Now function 0 calls function 1, function 1 starts at time 2, executes 4 units of time and end at time 5.
Function 0 is running again at time 6, and also end at the time 6, thus executes 1 unit of time. 
So function 0 totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4 units of time.
Note:
Input logs will be sorted by timestamp, NOT log id.
Your output should be sorted by function id, which means the 0th element of your output corresponds to the exclusive time of function 0.
Two functions won't start or end at the same time.
Functions could be called recursively, and will always end.
1 <= n <= 100
*/

// 60ms 6%
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;
        for(String log: logs) {
            String[] split = log.split(":");
            if(!stack.isEmpty()) {
                res[stack.peek()] += Integer.parseInt(split[2]) - prevTime;
            }
            prevTime = Integer.parseInt(split[2]);
            if(split[1].equals("start")) {
                stack.push(Integer.parseInt(split[0]));
            } else {
                res[stack.pop()]++;
                prevTime++;
            }
        }
        return res;
    }
}


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> deque = new LinkedList<int[]>();
        for (String log : logs) {
            int index_1 = log.indexOf(":");
            int index_2 = log.indexOf(":", index_1 + 1);
            int curNum = Integer.parseInt(log.substring(0, index_1));
            int curTimestamp = Integer.parseInt(log.substring(index_2 + 1, log.length()));
            if (index_2 - index_1 > 5) {
                if (!deque.isEmpty()) {
                    int[] top = deque.peek();
                    res[top[0]] += curTimestamp - top[1];
                }
                deque.push(new int[] {curNum, curTimestamp});
            } else {
                int[] top = deque.poll();
                res[curNum] += curTimestamp - top[1] + 1;
                if (!deque.isEmpty()) {
                    top = deque.peek();
                    top[1] = curTimestamp + 1;
                }
            }
        }
        return res;
    }
}

// 30ms 99%
// same idea, but change the string equals "start" (slow) to compare index 
// if the difference of the index is > 5, then it is start.
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;
        for(String log: logs) {
            int idIndex = log.indexOf(":");
            int timeIndex = log.indexOf(":", idIndex+1);
            int id = Integer.parseInt(log.substring(0,idIndex));
            int curTime = Integer.parseInt(log.substring(timeIndex+1, log.length()));
            if(!stack.isEmpty()) {
                res[stack.peek()] += curTime - prevTime;
            }
            prevTime = curTime;
            if(timeIndex - idIndex > 5) {
                stack.push(id);
            } else {
                res[stack.pop()]++;
                prevTime++;
            }
        }
        return res;
    }
}
