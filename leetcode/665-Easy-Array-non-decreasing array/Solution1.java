/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 08, 2018
 Problem:    non-decreasing array
 Difficulty: easy
 Notes:

Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].


*/

// 12ms 99%
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean gap = false;
        int index = 0;
        for(int i = 0; i< nums.length-1; i++){
            if(nums[i] > nums[i+1]) {
                if(gap) {
                    return false;
                } else {
                    gap = true;
                    index = i;
                }
            }
        }
        if(index==0 || nums[index-1] <= nums[index+1] || index== nums.length-2 || nums[index] <= nums[index+2]) return true;
        return false;
    }
}