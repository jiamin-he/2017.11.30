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
      int length = nums.length;
      if(length == 0) return;
      int[] result = new int[length];
      k= k % length;
      System.arraycopy(nums, length - k, result, 0, k);
      System.arraycopy(nums, 0, result, k, length - k);
      System.arraycopy(result, 0, nums, 0, length);
      return;
    }

    public static void main(String[] args) {
        
    }
}
