/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    Minimum Size Subarray Sum
 Difficulty: Medium
 Notes:
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).


*/

// 2ms 60%
// O(N)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length, sum = 0, minLen = Integer.MAX_VALUE;
        for(int i = 0, j = 0; j < len; j++){
            sum += nums[j];
            if(sum >= s) {
                while(sum >= s) {
                    sum -= nums[i++];
                }
                minLen = Math.min(minLen, j-(i-1)+1);
            }
        }
        return minLen==Integer.MAX_VALUE? 0:minLen;
    }
}