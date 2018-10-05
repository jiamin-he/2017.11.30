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


// O (N log N)
// 25ms 3%
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        return helper(nums, 0, nums.length-1);
    }
    public int helper(int[] nums, int left, int right) {
        if(left == right) return nums[left];
        int middle = left + (right - left)/2;
        int maxL = helper(nums, left, middle);
        int maxR = helper(nums, middle+1, right);
        int temp = 0, leftMax = nums[middle], rightMax = nums[middle+1];
        for(int i = middle; i >= left; i--) {
            temp += nums[i];
            if(temp > leftMax) leftMax = temp;
        }
        temp = 0;
        for(int i = middle+1; i <= right; i++) {
            temp += nums[i];
            if(temp > rightMax) rightMax = temp;
        }
        int maxM = leftMax + rightMax;
        return Math.max(Math.max(maxL,maxR),maxM);
    }
}