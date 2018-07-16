/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    Subarray Sum Equals K
 Difficulty: Medium
 Notes:
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

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