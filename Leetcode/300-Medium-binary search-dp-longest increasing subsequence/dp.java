/*
Author: Jiamin
Date: Jan 05, 2017
Problem: Longest Increasing Subsequence
Difficulty: medium
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

// TLE 
// more than O(n^2)
// rewrite this backtracking into dp.
class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = helper(nums, i);
            maxLen = Math.max(maxLen, temp);
        }
        return maxLen;
    }
    public int helper(int[] nums, int index) {
        int maxLen = 0, prev = nums[index];
        for(int i = index+1; i < nums.length; i++) {
            if(nums[i] > prev) {
                int temp = helper(nums, i);
                maxLen = Math.max(temp, maxLen);
            }
        }
        return maxLen+1;
    }
}

// O(n^2)
// dp
// 27ms 48%
class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] dp = new int[nums.length];
        for(int i = nums.length-1; i >= 0; i--) {
            int prev = nums[i];
            dp[i] = 1;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] > prev) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}