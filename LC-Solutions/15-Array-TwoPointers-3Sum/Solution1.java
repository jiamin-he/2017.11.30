/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 20, 2017
 Problem:    3sum
 Difficulty: Medium
 Notes:

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

import java.util.*;

class Solution1 {

    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (nums.length < 3) return res;
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length ; i++) {
    		if(i >= 1 && nums[i] == nums[i-1]) continue;
    		int sum = -nums[i];
    		int low = i + 1, high = nums.length - 1;
    		while(low < high){
    			if (nums[low] + nums[high] < sum) low++;
    			else if(nums[low] + nums[high] > sum) high--;
    			else {
    				res.add(Arrays.asList(nums[i],nums[low],nums[high]));
    				int temp = nums[low];
    				while(low < high && nums[++low] == temp) ;
    				temp = nums[high];
    				while(low < high && nums[--high] == temp) ;

    				//or 
    				// while(low < high && nums[low+1] == nums[low]) low++;
    				// while(low < high && nums[high-1] == nums[high]) high--;
    				// low++;
    				// high--;
    			}
    		}
    	}
    	return res;
    }

    public static void main(String[] args) {
        int[] nums = {-5,-1,-5,-4,2,1,-1,2,-4,-3,-2,-4};
        Solution1 s1 = new Solution1();
        List<List<Integer>> list = s1.threeSum(nums);
        
        for(int i = 0; i < list.size(); i++){
        	System.out.println(list.get(i));
        }
        
    }
}


// 2018 July 28 review
// 44ms 95%
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for ( int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i] != nums[i-1]) {
                int left = i+1, right = nums.length-1, target = 0-nums[i];
                while(left < right) {
                    int temp = nums[left] + nums[right];
                    if(temp < target) {
                        left++;
                    } else if (temp > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        int l = nums[left], r = nums[right];
                        while(left < right && nums[++left] == l);
                        while(right > left && nums[--right] == r);
                    }
                }
            }
        }
        return res;
    }
}

// Sep 25 2018 review
// time: O(n^2) 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = nums[i] * (-1);
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int cur = nums[left] + nums[right];
                if(cur < target) {
                    left++;
                } else if (cur > target) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    right--;
                }
            }
        }
        return res;
    }
}
