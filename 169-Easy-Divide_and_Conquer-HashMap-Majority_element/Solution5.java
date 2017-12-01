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
        if (nums.length == 1) return nums[0];
        int leftM = majorityElement(Arrays.copyOfRange(nums, 0, nums.length/2));
        int rightM = majorityElement(Arrays.copyOfRange(nums, nums.length/2, nums.length));
        int counterLeft = 0;
        for (int num : nums) {
            if (num == leftM) counterLeft++;
            if (counterLeft > nums.length/2) return leftM;
        }
        return rightM;    
    }

    public static void main(String[] args) {
        
    }
}
