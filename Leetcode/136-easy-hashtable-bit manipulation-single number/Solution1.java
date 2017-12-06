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

//巨慢无比。23ms

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            res.put(nums[i],res.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: res.entrySet()){
            if(entry.getValue() == 1) return entry.getKey(); 
        }
        return 0;
    }
}

