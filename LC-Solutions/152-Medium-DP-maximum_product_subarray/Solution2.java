/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 28, 2017
 Problem:    Maximum Product Subarray
 Difficulty: Medium
 Notes:
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

*/

class Solution {
    public int maxProduct(int[] nums) {
        int leftMax = nums[0], rightMax = nums[nums.length-1];
        for(int i = 0, max = 1; i < nums.length; i++){
            max *= nums[i];
            if(max > leftMax) leftMax = max;
            if(max == 0) max = 1;
        }
        for(int i = nums.length-1, max = 1; i >= 0; i--){
            max *= nums[i];
            if(max > rightMax) rightMax = max;
            if(max == 0) max = 1;
        }
        return Math.max(leftMax,rightMax);
    }
}


// July 16th 2018 review
// 100%
class Solution {
    public int maxProduct(int[] nums) {
        int lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, left = 1, right = 1;
        for(int i= 0; i < nums.length; i++){
            left *= nums[i];
            right *= nums[nums.length-i-1];
            lmax = Math.max(lmax,left);
            rmax = Math.max(rmax,right);
            if(nums[i] == 0) {
                left = 1;
            }
            if(nums[nums.length-i-1]==0) {
                right = 1;
            }
            
        }
        return Math.max(lmax,rmax);
    }
}