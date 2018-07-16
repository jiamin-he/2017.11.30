/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    move zeroes
 Difficulty: easy
 Notes:
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

  */


// 3ms 18%
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int insPos = 0;
        for ( int n: nums) {
            if(n != 0) {
                nums[insPos++] = n;
            }
        }
        while(insPos < nums.length) {
            nums[insPos++] = 0;
        }
    }
}

// two pointers from head
class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            } 
        }
    }
}
