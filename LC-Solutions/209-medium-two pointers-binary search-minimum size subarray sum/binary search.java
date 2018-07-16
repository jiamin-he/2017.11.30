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

// 4ms 20%
// O(N log N)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 1, j = nums.length, minLen = 0;
        while(i <= j){
            int mid = i+(j-i)/2;
            if(windowExist(mid,nums,s)) {
                j = mid-1;
                minLen = mid;
            } else {
                i = mid+1;
            }
        }
        return minLen;
    }
    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i>= size) sum -= nums[i-size];
            sum += nums[i];
            if(sum >= s) return true;
        }
        return false;
    }
}