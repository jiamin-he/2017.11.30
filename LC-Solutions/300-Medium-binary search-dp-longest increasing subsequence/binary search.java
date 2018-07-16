/*
Author: Jiamin
Date: Jan 05, 2017
Problem: Longest Increasing Subsequence
Difficulty: medium
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

// 22ms 77%
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        int len = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] > b[0]) return 1;
                else if (a[0] < b[0]) return -1;
                else return b[1]-a[1];
            }
        });
        int[] dp = new int[len];
        int size = 0;
        for(int[] e: envelopes) {
            int left = 0, right = size, middle = 0;
            while(left < right) {
                middle = left + (right - left)/2;
                if(dp[middle] < e[1]) left = middle+1;
                else right = middle;
            }
            dp[left] = e[1];
            if(left == size) size++;
        }
        // 也可以用Arrays的内置函数
        // 会慢一点点
        // for(int[] e: envelopes) {
        //     int index = Arrays.binarySearch(dp,0,size,e[1]);
        //     if(index < 0) index = -(index+1);
        //     dp[index] = e[1];
        //     if(index == size) size++;
        // }
        return size;
    }
}
