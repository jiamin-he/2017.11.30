/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 19, 2018
 Problem:    Search a 2D Matrix II
 Difficulty: Medium
 Notes:

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.



*/

// 15ms 8%
// M*N matrix
// time: worst O(MN)
// space: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1 || matrix[0].length < 1) return false;
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}