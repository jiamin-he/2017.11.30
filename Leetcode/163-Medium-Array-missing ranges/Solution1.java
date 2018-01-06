/*
Author: Jiamin
Date: Jan 04, 2017
Problem: missing ranges
Difficulty: medium

Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

*/


// 6ms 4.78%
// O(n)
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            res.add(helper(lower,upper));
            return res;  
        } 
        if(lower < nums[0]) res.add(helper(lower, nums[0]-1));
        int len = nums.length;
        for(int i = 0; i < len-1; i++) {
            if(nums[i] == nums[i+1] || nums[i] == nums[i+1]-1) continue;
            res.add(helper(nums[i]+1,nums[i+1]-1));
        }
        if(upper > nums[len-1]) res.add(helper(nums[len-1]+1,upper));
        return res;
    }
    
    public String helper(int start, int end ) { 
        return start==end? String.valueOf(start):String.format("%d->%d", start, end);
    }
}