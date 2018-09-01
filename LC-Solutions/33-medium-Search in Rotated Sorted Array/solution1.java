/*
Author: Jiamin
Date: Aug 26, 2018
Problem: Search in Rotated Sorted Array
Difficulty: medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length, left = 0, right = len-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        int rot = left;
        left = 0;
        right = len-1;
		// <= is very important! [1] -1 this case will fail if it is left < right!!!
        while(left <= right) {
            int mid = left + (right-left)/2;
            int realMid = (mid+rot)%len;
            if(nums[realMid] == target) {
                return realMid;
            } else if(nums[realMid] > target){
				// when we change to "left <= right" you cannot use "right = mid" then it will result in infinite loop!!!
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}