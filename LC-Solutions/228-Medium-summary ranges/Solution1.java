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


// Jun 24 , 2018 review
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length < 1) return res;
        int start = 0, end = 0;
        for(int i = 0; i < nums.length -1; i++) {
            if(nums[i+1] == nums[i]+1){
                end++;
            } else {
                if(start == end) {
                    res.add(Integer.toString(nums[start]));
                    start++;
                    end++;
                } else {
                    String s = nums[start] + "->" + nums[end];
                    res.add(s);
                    end++;
                    start=end;
                }
            }
        }
        if(start == end) {
            res.add(Integer.toString(nums[start]));
        } else {
            String s = nums[start] + "->" + nums[end];
            res.add(s);
        }
        return res;
    }
}

// July 17 2018 review
// 1ms 84%
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length < 1) return list;
        int start = nums[0], end = nums[0]-1;
        for(Integer i: nums) {
            if(i == end+1) {
                end = i;
            } else {
				
				// remember: this String.format()
				// if (cur == start) {
// 					res.add(String.format("%d", cur));
// 				} else {
// 					res.add(String.format("%d->%d", start, cur));
// 				}
								
                if(start == end) {
                    list.add(Integer.toString(start));
                } else {
                    list.add(start+"->"+end);
                }
                start = i;
                end = i;
            }
        }
        if(start == end) {
            list.add(Integer.toString(start));
        } else {
            list.add(start+"->"+end);
        }
        return list;
    }
}