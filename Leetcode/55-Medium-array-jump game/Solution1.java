/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 07, 2017
 Problem:    jump game
 Difficulty: medium
 Notes:

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

*/

// stack over flow 
// 1,1,1,1,1 很多个 1 的test case 跑不过
class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums,0);
    }
    public boolean canJump(int[] nums, int index) {
        if(index >= nums.length-1) return true;
        int step = nums[index];
        if(step <= 0) return false;
        for(int i = step; i > 0; i--) {
            if(canJump(nums,index+step)) return true;
        }
        return false;
    }
}