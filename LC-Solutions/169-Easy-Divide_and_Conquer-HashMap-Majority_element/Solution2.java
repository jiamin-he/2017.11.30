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

    public int findCandidate(int[] nums){
      int count = 0, candidate = nums[0];
      for (int i = 0; i < nums.length; i++) {
        if (candidate == nums[i]) count++;
        else count--;
        if (count == 0) {
          candidate = nums[i];
          count = 1;
        }
      }
      if(checkMajority(nums, candidate)) return candidate;
      return 0;
      }

    public boolean checkMajority(int[] nums, int candidate){
      int count = 0; 
      int length = nums.length;
      for (int i = 0; i < length; i++)
        if (nums[i] == candidate) count++;
      if (count > length / 2) return true;
      return false;
    }

    public static void main(String[] args) {
        
    }
}
