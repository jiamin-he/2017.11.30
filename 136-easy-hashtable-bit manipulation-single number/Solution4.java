/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 15, 2017
 Problem:    Single Number
 Difficulty: easy
 Notes:
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


*/

//1ms。bit manipulation 巨快

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i = 0; i < nums.length; i++){
            a ^= nums[i];
        }
        return a;
    }
}