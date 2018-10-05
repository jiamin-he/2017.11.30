/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 26, 2018
 Problem:    Search in Rotated Sorted Array II
 Difficulty: Medium
 Notes:
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/

// 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
// 在这种情况下是无法使用二分法的，复杂度是O(n)
// 因此写个for循环最坏也是O(n)，那就写个for循环就好了

// 1ms 50%
// O(log n), worst O(n)
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length < 1) return false;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }
            if(nums[left] == nums[right]) {
                left++;
            } else if (nums[left] < nums[right]) {
                if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if(target < nums[right]) {
                    if(nums[mid] < target || nums[mid] > nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                } else {
                    if(nums[mid] > target || nums[mid] < nums[right]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return nums[left] == target;
    }
}