/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 02, 2017
 Problem:    Daily Temperatures
 Difficulty: Medium
 Notes:

Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];
        if(N < 1) return res;
        Stack<Integer> candidates = new Stacwk<>();
        for(int i = 0; i < N-1; i++){
            if(temperatures[i] < temperatures[i+1]){
                res[i] = 1;
                while(!candidates.isEmpty()){
                    int temp = candidates.peek();
                    if(temperatures[temp] < temperatures[i+1]){
                        candidates.pop();
                        res[temp] = i+1-temp;
                    } else{
                        break;
                    }
                }
            } else{
                candidates.push(i);
            }
        }
        return res;
    }
}
