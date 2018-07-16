/*
Author: Jiamin
Date: Jan 04, 2017
Problem: Container With Most Water
Difficulty: medium
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/


// 5ms 99%
class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int start = 0, end = height.length-1;
        int res = Integer.MIN_VALUE;
        while(start < end) {
            int h = Math.min(height[start], height[end]);
            res = Math.max(h*(end-start), res);
            if(height[end] > h) start++;
            else if(height[start] > h) end--;
            else if(height[start] == height[end]) {
                if(height[start+1] > height[end-1]) start++;
                else end--;
            }
        }
        return res;
    }
}

// July 11th 2018 review
// 5ms 99%
class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(start < end) {
            int minHeight = Math.min(height[start], height[end]);
            int temp = minHeight*(end-start);
            if(temp > maxArea) {
                maxArea = temp;
            }
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea==Integer.MIN_VALUE? 0:maxArea;
    }
}