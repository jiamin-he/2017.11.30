/*
Author: Jiamin
Date: Aug 25, 2018
Problem: Find First and Last Position of Element in Sorted Array
Difficulty: medium
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*/

// 4ms 100%
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length<1)return new int[]{-1,-1};
        int[] ret = new int[]{-1,-1};
        int i = 0, j = nums.length-1;
        while(i<j){
            int mid = i + (j-i)/2;
            if(nums[mid]<target) i = mid+1;
            else j = mid;
        }
        if(nums[i]!=target)return ret;
        else ret[0] = i;

        j = nums.length-1;
        while(i<j){
            int mid = i + (j-i)/2 + 1;
            if(nums[mid]>target)j=mid-1;
            else i = mid;
        }
        ret[1]=j;
        return ret;
    }
}