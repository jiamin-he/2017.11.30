/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 02, 2017
 Problem:    spiral matrix II
 Difficulty: medium
 Notes:

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res= new int[n][n];
        int start = 1, level = 0, maxLevel = n/2;
        while(level <= maxLevel) {
            for(int i = level, j = level; j < n-level; j++) {
                res[i][j] = start++;
            }
            for(int j = n-level-1, i = level+1; i < n-level; i++) {
                res[i][j] = start++;
            }
            for(int i = n-level-1, j = n-level-2; i != level && j >= level; j--) {
                res[i][j] = start++;
            }
            for(int j = level, i = n-level-2; j != n-level-1 && i > level; i--) {
                res[i][j] = start++;
            }
            level++;
        }
        return res;
    }
}

