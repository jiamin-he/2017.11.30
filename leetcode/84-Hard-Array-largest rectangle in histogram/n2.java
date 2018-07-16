/*
Author: Jiamin
Date: July 11, 2017
Problem: largest rectangle in histogram
Difficulty: hard

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
[pic]

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
[pic]

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int len = heights.length;

        for(int i = 0; i<len; i++) {
            int[] dp = new int[len];
            dp[i] = heights[i];
            maxArea = Math.max(heights[i],maxArea);
            for (int j = i+1; j < len; j++) {
                dp[j] = Math.min(dp[j-1], heights[j]);
                maxArea = Math.max((dp[j]*(j-i+1)),maxArea);
            }
        }
        return maxArea==Integer.MIN_VALUE?0:maxArea;
    }
}