/*
Author: Jiamin
Date: Jul 19, 2018
Problem: Longest Increasing Subsequence
Difficulty: medium
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

// this one is incorrect!!!!!
// in this solution, every element in behind will be taken.
// but this is not true!!!
// e.g. [1,3,6,7,9,4,10,5,6]
class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        if(nums.length < 1) return 0;
        stack.push(nums[0]);
        for(int i = 0;  i< nums.length; i++) {
            if(nums[i] > stack.peek()) {
                stack.push(nums[i]);
            } else {
                res = Math.max(res, stack.size());
                while(!stack.isEmpty() && stack.peek() >= nums[i]) {
                    stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return Math.max(res,stack.size());
    }
}