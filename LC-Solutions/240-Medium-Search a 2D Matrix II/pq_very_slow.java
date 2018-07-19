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

// 790ms 0%
// M*N matrix
// time: worst: O(MNlogN)
// space: O(N)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        PriorityQueue<cell> minHeap = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1._val,o2._val)));
        for(int i = 0 ; i < matrix.length ; i++){
            if(matrix[i][0] == target)
                return true;
            minHeap.offer(new cell(i,0,matrix[i][0]));
        }
        while(!minHeap.isEmpty()){
            cell tmp = minHeap.poll();
            if(tmp._val > target)
                return false;
            if(tmp._val == target){
                return true;
            }
            if(tmp._col  < matrix[0].length - 1){
                minHeap.offer(new cell(tmp._row,tmp._col + 1, matrix[tmp._row][tmp._col + 1]));
            }
        }
        return false;

    }
    class cell{
        int _row ;
        int _col;
        int _val;
        public cell(int row,int col,int val){
            _row = row ;
            _col = col;
            _val = val;
        }
    }
}