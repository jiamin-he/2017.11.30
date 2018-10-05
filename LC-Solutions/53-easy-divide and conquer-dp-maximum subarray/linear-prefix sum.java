/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    Maximum Subarray
 Difficulty: Easy
 Notes:
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


*/


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i + 1] = sum;
        }
        
        int preMin = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < prefix.length; i++) {
            max = Math.max(prefix[i] - preMin, max);
            preMin = Math.min(prefix[i], preMin);
        }
        
        return max;
    }
}
