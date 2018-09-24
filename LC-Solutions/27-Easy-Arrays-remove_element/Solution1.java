/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 8, 2017
 Problem:    Remove Element
 Difficulty: Easy
 Notes:
Given an array and a value, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

*/



class Solution {
    public int removeElement(int[] nums, int val) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != val) nums[ret++] = nums[i];
        }
        return ret;
    }
}


// Jun 24 2018 review
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 0) return 0;
        int end = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[end++] = nums[i];
            }
        }
        return end;
    }
}