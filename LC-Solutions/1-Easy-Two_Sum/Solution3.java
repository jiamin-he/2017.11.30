/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 9, 2017
 Problem:    Two Sum
 Difficulty: Easy
 Notes:

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 Solution: Hashmap so that can easily get the corresponding index;
                Attention---how to return the result -- (index, key, value)
                To find the one that matches!
*/

class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> cache = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i])) {
                return new int[] { cache.get(nums[i]), i };
            } else {
                cache.put(target - nums[i], i);
            }
        }
        
        return new int[]{};
    }
}

// 07 28 2018 review 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for ( int i =0 ;  i< nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(target-nums[i],i);
            } else {
                return new int[]{map.get(nums[i]),i};   
            }
        }
        return new int[2];
    }
}