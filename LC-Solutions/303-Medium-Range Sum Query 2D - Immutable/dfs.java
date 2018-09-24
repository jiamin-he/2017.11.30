/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 19, 2018
 Problem:    Range Sum Query 2D - Immutable
 Difficulty: medium
 Notes:
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.

*/

// 78ms 73%
// initialize O(n^2)
// getSum O(1)
class NumMatrix {
    
    int[][] valMatrix;
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        if(matrix.length < 1 || matrix[0].length < 1) return;
        int m = matrix.length, n = matrix[0].length;
        valMatrix = new int[m][n];
        sumMatrix = new int[m][n];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                valMatrix[i][j] = matrix[i][j];
                if(i >= 1 && j>= 1) 
                    sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i][j];
                else if (i>=1) 
                    sumMatrix[i][j] = sumMatrix[i-1][j] + matrix[i][j];
                else if(j>=1)
                    sumMatrix[i][j] = sumMatrix[i][j-1] + matrix[i][j];
                else 
                    sumMatrix[i][j] = matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(col1 >=1 && row1 >= 1)
            return sumMatrix[row2][col2] - sumMatrix[row2][col1-1] - sumMatrix[row1-1][col2] + sumMatrix[row1-1][col1-1];
        else if (col1>=1)
            return sumMatrix[row2][col2] - sumMatrix[row2][col1-1];
        else if (row1 >= 1)
            return sumMatrix[row2][col2] - sumMatrix[row1-1][col2];
        else 
            return sumMatrix[row2][col2];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */