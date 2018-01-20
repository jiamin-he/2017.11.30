/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 14, 2017
 Problem:    Sparse Matrix Multiplication
 Difficulty: Medium
 Notes:

Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |

*/

// 55ms 93%
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int ar = A.length, c = A[0].length, bc = B[0].length;
        int[][] C = new int[ar][bc];
        for(int i = 0; i < ar; i++) {
            for(int j = 0; j < c; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < bc; k++) {
                        if (B[j][k] != 0) C[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return C;
    }
}