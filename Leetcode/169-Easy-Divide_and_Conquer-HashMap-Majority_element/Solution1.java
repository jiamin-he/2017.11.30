/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 5, 2017
 Problem:    Majority Element
 Difficulty: Easy
 Notes:

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

import java.util.*;

class Solution1 {
    
    public int majorityElement(int[] nums){
      Map<Integer, Integer> map = new HashMap<>();
      int length = nums.length;
      for (int i = 0; i < length ; i++ ) {
        if (!map.containsKey(nums[i])) map.put(nums[i],1);
        else map.put(nums[i], map.get(nums[i])+1);
        if (map.get(nums[i]) > (length / 2)) return nums[i];
      }
      return 0;
    }

    public static void main(String[] args) {
        
    }
}
