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

//巨慢无比。19ms

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if (res.contains(nums[i])) res.remove(nums[i]);
            else res.add(nums[i]);
        }
        return (int)res.toArray()[0];
    }
}
