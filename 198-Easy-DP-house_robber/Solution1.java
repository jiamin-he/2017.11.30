/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 30, 2017
 Problem:    house robber
 Difficulty: Easy
 Notes:
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length < 1) return 0;
        int[] rob = new int[nums.length+1];
        rob[0] = 0;
        rob[1] = nums[0];
        for(int i = 2; i<= nums.length; i++){
            rob[i] = Math.max(rob[i-1], rob[i-2] +nums[i-1]);
        }
        return rob[nums.length];
    }
}


// save space
class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1) return 0;
        int pprev = 0, prev = 0;
        for(int n: nums){
            int temp = prev;
            prev = Math.max(pprev + n, prev);
            pprev = temp;
        }
        return prev;
    }
}