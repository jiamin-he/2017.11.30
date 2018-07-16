/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    Sort Colors
 Difficulty: Medium
 Notes:
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

*/


// 1ms 4%
// 其实相当于scan 了两次 o-2n
// 所以慢
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int n : nums){
            count[n]++;
        }
        int i = 0;
        while(i < count[0]) {
            nums[i++] = 0;
        }
        while(i < count[1] + count[0]) {
            nums[i++] = 1;
        }
        while (i < nums.length) {
            nums[i++] = 2;
        }
    }
}

// one pass in place solution
// 0 ms 39% 
// 第二次判断时 由于换过来的可能是2 所以不能用else
// 又由于再换过来的可能是0 所以要i-- 退回去一个
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length-1;
        for(int i = 0; i <= two; i++) {
            if(nums[i] == 0) {
                swap(i,zero++,nums);
            }
            if(nums[i] == 2) {
                swap(i--,two--,nums);
            }
        }
    }
    
    public void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
