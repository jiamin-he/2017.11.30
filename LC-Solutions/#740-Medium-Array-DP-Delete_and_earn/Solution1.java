/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 02, 2017
 Problem:    Delete and Earn
 Difficulty: Medium
 Notes:

Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:
Input: nums = [3, 4, 2]
Output: 6
Explanation: 
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.
Example 2:
Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation: 
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.
Note:

The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] res = new int[N];
        if(N < 1) return res;
        Stack<Integer> candidates = new Stack<>();
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
