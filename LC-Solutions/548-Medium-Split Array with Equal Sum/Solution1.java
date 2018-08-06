/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 4th, 2018
 Problem:    Split Array with Equal Sum
 Difficulty: medium
 Notes:
Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
Example:
Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5. 
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
Note:
1 <= n <= 2000.
Elements in the given array will be in range [-1,000,000, 1,000,000].

*/

// 16ms 93%
class Solution {
    public boolean splitArray(int[] nums) {
        if(nums == null || nums.length < 7) return false;
        int len = nums.length, sum1 = nums[0], sum4 = nums[len-1], totalSum = 0;
        for( int h = 0; h < len; h++) {
            totalSum += nums[h];
        }
        for( int i = 1; i <= len-6; i++) {
            sum4 = nums[len-1];
            for( int k = len-2; k >= i+4; k--) {
                if(sum1 == sum4) {
                    int tempSum = totalSum - sum1 - sum4 - nums[i] - nums[k];
                    int sum2 = 0, sum3 = tempSum - nums[i+1];
                    for( int j = i+2; j <= k-2; j++) {
                        sum2 += nums[j-1];
                        sum3 -= nums[j];
                        if(sum2 == sum3 && sum2 == sum4) return true;
                    }
                } 
                sum4 += nums[k];
            }
            sum1+=nums[i];
        }
        return false;
    }
}

// 思考 把一开始preparation那里的求和换成下面这一个数组存起来的话，会好算一下，减少了每一次for loop之后值的运算 不过浪费了空间
		int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }