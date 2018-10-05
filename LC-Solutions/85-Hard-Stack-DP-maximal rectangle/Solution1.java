/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 14, 2018
 Problem:    maximal rectangle
 Difficulty: hard
 Notes:

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

*/


// 9ms 98%
// O(n^2)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length < 1) return 0;
        int[] heights = new int[matrix[0].length];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            res = Math.max(largestRectangleArea(heights),res);
        }
        return res;
    }
    
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