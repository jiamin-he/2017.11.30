/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 5, 2017
 Problem:    Roman to integer
 Difficulty: Easy
 Notes:
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
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
