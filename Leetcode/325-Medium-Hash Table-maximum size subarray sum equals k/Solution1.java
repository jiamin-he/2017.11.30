/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 09, 2017
 Problem:    Maximum Size Subarray Sum Equals k
 Difficulty: medium
 Notes:
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/

// 对比下面三个版本
// 由于第一个 里面的 if else if 其实应该是 if if
// 导致 [1,1,1,0,0] k=1 
// 后面的0没有被计入
// 然后我就还去判断了后面是0不是0的情况
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k)) maxLen = Math.max(maxLen, i+1-map.get(sum-k));
            else if(!map.containsKey(sum)) map.put(sum,i+1);
        }
        return maxLen;
    }
}


// 29ms 54%
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            int iMove = i;
            if(map.containsKey(sum-k)) {
                while( iMove+1 < nums.length && nums[iMove+1] == 0) iMove++;
                int cur = iMove+1-map.get(sum-k);
                maxLen = Math.max(cur,maxLen);
            }
            if(!map.containsKey(sum)) map.put(sum,i+1);
            i = iMove;
        }
        return maxLen;
    }
}

// 但其实正常写就可以了！！！
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k)) {
                int cur = i+1-map.get(sum-k);
                maxLen = Math.max(cur,maxLen);
            }
            if(!map.containsKey(sum)) map.put(sum,i+1);
        }
        return maxLen;
    }
}