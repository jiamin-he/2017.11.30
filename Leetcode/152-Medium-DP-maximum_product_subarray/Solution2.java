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
