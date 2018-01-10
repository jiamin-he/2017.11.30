/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    Subarray Sum Equals K
 Difficulty: Medium
 Notes:
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

*/

// O(n^2)
// 568 ms 4%
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int res = 0;
            for(int j = i; j < nums.length; j++) {
                res+=nums[j];
                if(res == k) {
                    count++;
                }
            }
        }
        return count;
    }
}


// 46ms 39%
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 一定要先更新count 再去put
            // 思考一下test case 【1】 0
            // if先 put 再 update count，答案不对 return 1 实际上应该是0
            count += map.getOrDefault(sum-k,0);
            //将这句改成
            // if(map.containsKey(sum-k)) count+= map.get(sum-k);
            // is 36ms 90%
            // get or default 会比 containskey慢的
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}