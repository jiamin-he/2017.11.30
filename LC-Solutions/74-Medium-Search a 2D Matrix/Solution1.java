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


// regard it as a 1-D array
// 6ms 85%
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;
        if(N==0)return false;
        int M = matrix[0].length;
        if(M==0)return false;
        int start = 0;
        int end = N*M-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int col = mid%M;
            int row = mid/M;
            if(matrix[row][col]==target){
                return true;
            }
            else if ( matrix[row][col]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}