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

//巨慢无比。17ms

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> res = new HashSet<>();
        int sum = 0;
        int sum2 = 0;
        for(int i = 0; i < nums.length; i++){
            res.add(nums[i]);
            sum += nums[i];
        }
        for(Integer i: res){
            sum2 += (int)i;
        }
        return 2*sum2 - sum;
    }
}