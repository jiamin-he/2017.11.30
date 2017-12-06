/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 5, 2017
 Problem:    Rotate Array
 Difficulty: Easy
 Notes:

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

*/

import java.util.*;

class Solution1 {
    
    public void rotate(int[] nums, int k){
      if (nums.length < 2) return;
      k = k % nums.length;
      reverse(nums,0,nums.length-1);
      reverse(nums,0,k-1);
      reverse(nums,k,nums.length-1);
      return;
    }

    public void reverse(int[] nums, int start, int end){
      
      while(start < end){
        int temp = nums[start];
        nums[start++] = nums[end];
        nums[end--] = temp;
      }
      return;
    }

    public static void main(String[] args) {
        
    }
}
