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

// 10ms 90%
// O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(-1);
        if(heights.length < 1) return 0;
        int maxArea = 0;
        for(int i=0; i < heights.length; i++) {
            while(stack.peek()!=-1 && heights[stack.peek()] > heights[i]) {
                maxArea = Math.max(maxArea, (heights[stack.pop()]*(i-stack.peek()-1)));
            }
            stack.push(i);
        }
        while(stack.peek()!=-1) {
            maxArea = Math.max(maxArea,(heights[stack.pop()]*(heights.length-stack.peek()-1)));
        }
        return maxArea;
    }
}