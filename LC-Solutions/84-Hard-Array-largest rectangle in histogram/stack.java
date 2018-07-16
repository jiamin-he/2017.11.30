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
        stack.push(0);
        if(heights.length < 1) return 0;
        int maxArea = heights[0];
        for(int i=1; i < heights.length; i++) {
            int firstPeek = stack.peek();
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int popIndex = stack.pop();
                int temp;
                if(stack.isEmpty()) {
                    temp = -1;
                } else {
                    temp = stack.peek();
                }
                maxArea = Math.max(maxArea, ((firstPeek-temp)*heights[popIndex]));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int popIndex = stack.pop();
            int temp;
            if(stack.isEmpty()) {
                temp = -1;
            } else {
                temp = stack.peek();
            }
            maxArea = Math.max(maxArea,((heights.length-temp-1)*heights[popIndex]));
        }
        return maxArea;
    }
}
