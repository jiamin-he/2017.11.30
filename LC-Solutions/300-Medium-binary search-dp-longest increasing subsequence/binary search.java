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

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] record = new int[nums.length + 1];
        record[0] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];
            if(cur <= record[0]){
                record[0] = cur;
            }else if(crt > record[len - 1]){
                record[len] = cur;
                len++;
            }else{
                insertNum(record, len, cur);
            }
        }
        return len;
    }
    
    private void insertNum(int[] record, int len, int cur){
        int start = 0, end = len - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(record[mid] == cur){
                return;
            }else if(record[mid] < cur){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(record[start] >= cur){
            record[start] = cur;
        }else{
            record[end] = cur;
        }
    }
}