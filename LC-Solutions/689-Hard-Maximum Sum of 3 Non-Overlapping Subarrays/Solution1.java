/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 14, 2017
 Problem:    Maximum Sum of 3 Non-Overlapping Subarrays
 Difficulty: Hard
 Notes:

In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example:
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Note:
nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).
*/

// 11ms 40%
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        //W is an array of sums of windows
        int[] W = new int[nums.length - K + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= K) sum -= nums[i-K];
            if (i >= K-1) W[i-K+1] = sum;
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1, -1};
        for (int j = K; j < W.length - K; j++) {
            int i = left[j - K], k = right[j + K];
            if (ans[0] == -1 || W[i] + W[j] + W[k] >
                    W[ans[0]] + W[ans[1]] + W[ans[2]]) {

                ans[0] = i;
                ans[1] = j;
                ans[2] = k;
            }
        }
        return ans;
    }
}


// 10ms 50%
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum = 0;
        int[] sumArr = new int[nums.length - k + 1];
        int[] left = new int[nums.length - k + 1];
        int[] right = new int[nums.length - k + 1];
        // calc sum
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(i >= k) sum -= nums[i - k];
            // because sumArr[i] is from i to i + k - 1
            if(i >= k - 1) sumArr[i - k + 1] = sum;
        }
        
        // calc left arr
        int best = 0;
        for(int i = 0; i < sumArr.length; i++) {
            if(sumArr[i] > sumArr[best]) {
                best = i;
            }
            left[i] = best;
        }
        
        // calc right arr
        best = sumArr.length - 1;
        for(int i = sumArr.length - 1; i >= 0; i--) {
            if(sumArr[i] >= sumArr[best]) {
                best = i;
            }
            right[i] = best;
        }
        
        // calc res[]
        int ansSum = 0;
        int[] res = {-1, -1, -1};
        for(int j = k; j < sumArr.length - k; j++) {
            int tmpSum = sumArr[left[j - k]] + sumArr[j] + sumArr[right[j + k]];
            if(tmpSum > ansSum) {
                res = new int[]{left[j - k], j, right[j + k]};
                ansSum = tmpSum;
            }
        }
        return res;
    }
}