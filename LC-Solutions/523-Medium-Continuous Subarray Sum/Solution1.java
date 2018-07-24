/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 21st, 2018
 Problem:    Continuous Subarray Sum
 Difficulty: medium
 Notes:
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
*/

// 113ms 2%
// 可以不用每次作差来compare
// 直接比余数就好了呀
// 这里的复杂度是 O(n^2)
// so very slow
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            for (int j: map.keySet()) {
                if(sum-j == 0 && k == 0 && (i-map.get(j) >= 2)) return true;
                if(k!=0 && (sum-j)%k==0 && (i-map.get(j) >= 2)) return true;
            }
            if(!map.containsKey(sum)) {
                map.put(sum,i);
            }
        }
        return false;
    }
}

//7ms 78%
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            if(k!= 0) sum %= k;
            if(map.containsKey(sum)) {
                if(map.get(sum) < i-1) return true;
            } else {
                map.put(sum,i);
            }
        }
        return false;
    }
}