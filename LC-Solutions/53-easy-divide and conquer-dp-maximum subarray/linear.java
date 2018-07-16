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

// 17ms 18%
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0];
        for(int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(maxSum < sum) maxSum = sum;
            // maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}
