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

// 2ms 100%
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            left[i] = i;
            while((left[i]-1)>=0 && heights[left[i]-1] >= heights[i]) {
                // this is an important step!!!
                left[i] = left[left[i]-1];
            }
        }
        for(int i = n-1; i >= 0; i--) {
            right[i] = i;
            while((right[i]+1)<n && heights[right[i]+1] >= heights[i]) {
                right[i] = right[right[i]+1];
            }
        }
        for(int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i]-left[i]+1));
        }
        return res;
    }
}
