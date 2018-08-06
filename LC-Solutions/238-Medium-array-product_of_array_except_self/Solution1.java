/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 28, 2017
 Problem:    Product of Array Except Self
 Difficulty: medium
 Notes:
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


*/

// space: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            output[i] = 1;
        }
        for(int i = 1; i < nums.length; i++){
            output[i] = output[i-1]*nums[i-1];
        }
        for(int i = nums.length-2, temp = nums[nums.length-1]; i >= 0; i--){
            output[i] *= temp;
            temp *= nums[i];
        }
        return output;
    }
}

// 2ms 20%
// space: O(2n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 1) return nums;
        int len = nums.length;
        int[] left = new int[len], right = new int[len];
        left[0] = 1; right[len-1] = 1;
        for(int i = 1; i < len; i++) {
            left[i] = left[i-1] * nums[i-1];
            right[len-1-i] = right[len-i] * nums[len-i];
        }
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

// space: O(1)
// 1ms 100%
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 1) return nums;
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}