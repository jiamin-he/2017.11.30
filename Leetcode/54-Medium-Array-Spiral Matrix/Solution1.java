/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 02, 2017
 Problem:    spiral matrix
 Difficulty: medium
 Notes:

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

*/

// 2ms 55% 
// 
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int level = 0, maxLevel = (Math.min(m,n) + 1)/2;
        while(level < maxLevel) {
            for(int i = level, j = level; j < n-level; j++) {
                res.add(matrix[i][j]);
            }
            for(int j = n-level-1, i = level+1; i < m-level; i++) {
                res.add(matrix[i][j]);
            }
            for(int i = m-level-1, j = n-level-2; i != level && j >= level; j--) {
                res.add(matrix[i][j]);
            }
            for(int j = level, i = m-level-2; j != n-level-1 && i > level; i--) {
                res.add(matrix[i][j]);
            }
            level++;
        }
        
        return res;
    }
}