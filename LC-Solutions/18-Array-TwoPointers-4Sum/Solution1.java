/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 4, 2018
 Problem:    4sum
 Difficulty: Medium
 Notes:

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

*/

// 用跟 3sum一摸一样的思路
// 但是要记得把target复原啊！！！
// O(N^3)
// 34ms 74%
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for ( int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i] != nums[i-1]) {
                for(int j = i+1; j < nums.length; j++) {
                    if( j==i+1 || nums[j] != nums[j-1]) {
                        
                        int left = j+1, right = nums.length-1; 
                        target -= (nums[i]+nums[j]);
                        while(left < right) {
                            int temp = nums[left] + nums[right];
                            if(temp < target) {
                                left++;
                            } else if (temp > target) {
                                right--;
                            } else {
                                res.add(Arrays.asList(nums[i],nums[j], nums[left], nums[right]));
                                int l = nums[left], r = nums[right];
                                while(left < right && nums[++left] == l);
                                while(right > left && nums[--right] == r);
                            }
                        }
                        target += (nums[i]+nums[j]);
                    }
                }
            }
        }
        return res;
    }
}