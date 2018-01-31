/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 20, 2017
 Problem:    Toeplitz Matrix
 Difficulty: Easy
 Notes:

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 

Example 1:

Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: True
Explanation:
1234
5123
9512

In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
Example 2:

Input: matrix = [[1,2],[2,2]]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
Note:

matrix will be a 2D array of integers.
matrix will have a number of rows and columns in range [1, 20].
matrix[i][j] will be integers in range [0, 99].
*/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return true;
        int m = matrix.length, n = matrix[0].length;
        for(int i = m-1; i >= 0; i--) {
            for(int j = 1; i+j < m && j < n; j++) {
                if(matrix[i][0] != matrix[i+j][j]) return false;
            }
        }
        for(int i = 1; i >= 0; i--) {
            for (int j = 1; i+j < n && j < m; j++) {
                if(matrix[0][i] != matrix[j][i+j]) return false;
            }
        }
        return true;
    }
}