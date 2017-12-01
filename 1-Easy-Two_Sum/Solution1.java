/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 5, 2017
 Problem:    Two Sum
 Difficulty: Easy
 Notes:

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 Solution: 2 index, dual-cycle (o-n^2)
*/

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0; j<nums.length;j++){
                if((nums[i]+nums[j]==target)&&(i!=j)){
                    result[0]=j;
                    result[1]=i;
                    return result;
                }
                
            }
        }
       return result; 
    }
}
