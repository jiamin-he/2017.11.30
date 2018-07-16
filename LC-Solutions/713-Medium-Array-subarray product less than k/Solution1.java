/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 7, 2017
 Problem:    Subarray Product Less Than K
 Difficulty: medium
 Notes:

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.


*/


// dp
// O(N^2)
// TLE
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length, count = 0;
        int[][] dp = new int[len][len];
        for(int i = len - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            if(dp[i][i] < k) count++;
            else break;
            for(int j = i+1; j < len; j++) {
                dp[i][j] = dp[i][j-1]*nums[j];
                if(dp[i][j] < k) count++;
                else break;
            }
        }
        return count;
    }
}


// 25ms 48%
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length, count = 0, mul = 1;
        for(int i = 0, j = 0; j < len; j++) {
            mul *= nums[j];
            while(i < j+1 && mul >= k) mul/= nums[i++];
            if(i <= j) count += j - i +1;
        }
        return count;
    }
}


