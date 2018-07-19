/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 18, 2017
 Problem:    Search a 2D Matrix
 Difficulty: Medium
 Notes:
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

*/


// 6ms 85%
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1 || matrix[0].length < 1) return false;
        int row = find(matrix, target);
        if(row==-1) return false;
        int col = find(matrix[row], target);
        if(matrix[row][col] == target) return true;
        return false;
        
    }
    
    public int find (int[] matrix, int target) {
        int pos = -1;
        int start = 0, end = matrix.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(matrix[mid] <= target) {
                pos = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return pos;
    }
    
    public int find (int[][] matrix, int target) {
        int pos = -1;
        int start = 0, end = matrix.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(matrix[mid][0] <= target) {
                pos = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return pos;
    }
}