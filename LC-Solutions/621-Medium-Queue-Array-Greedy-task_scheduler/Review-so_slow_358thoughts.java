/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 24, 2017
 Problem:    task scheduler
 Difficulty: medium
 Notes:
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
*/

// using the same thought in the No.358.
// so bad
// 0%
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] schedule = new int[26];
        for(char task: tasks){
            schedule[task-'A']++;
        }
        int[] validIndex = new int[26];
        boolean[] result = new boolean[1];
        result[0] = true;
        // count
        int i = 0;
        while(result[0]) {
            result[0] = false;
            int cur = curIndex(i, schedule, validIndex, result);
            if(cur>-1){
                System.out.println((char)('A'+cur));
                schedule[cur]--;
                validIndex[cur] = i+n+1;
            }
            i++;
        }
        return i-1;
    }
    
    public int curIndex(int curPosition, int[] schedule, int[] validIndex, boolean[] result){
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < schedule.length; i++){
            if(schedule[i]>0 && schedule[i] > max && curPosition >= validIndex[i]){
                max = schedule[i];
                index = i;
            }
            if(schedule[i]>0){
                result[0] = true;
            }
        }
        return index;
    }
}