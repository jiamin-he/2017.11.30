/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 29, 2017
 Problem:    Summary Ranges
 Difficulty: Medium
 Notes:

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Example 2:
Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
*/

// O(n)

// 0ms 50%
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int start = 0, end = 0;
        for(int i=1; i <nums.length; i++) {
            if(nums[i] == nums[i-1]+1) end = i;
            else {
                if(start == end) {
                    res.add(Integer.toString(nums[start]));   
                } else {
                    res.add(new String(nums[start] + "->" + nums[end]));
                }
                start = i;
                end = i;
            } 
        }
        if(start == end) {
            res.add(Integer.toString(nums[start]));   
        } else {
            res.add(new String(nums[start] + "->" + nums[end]));
        }
        return res;
    }
}