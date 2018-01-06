/*
Author: Jiamin
Date: Jan 05, 2017
Problem: game of life
Difficulty: medium
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?


*/

// 1ms 13%
// O(mn)
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        int[][] count = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int live = 0;
                if(i > 0) {
                    if(j > 0 && board[i-1][j-1] == 1) live++;
                    if(j < n-1 && board[i-1][j+1] == 1) live++;
                    if(board[i-1][j] == 1) live++;
                }
                if(i < m-1) {
                    if(j > 0 && board[i+1][j-1] == 1) live++;
                    if(j < n-1 && board[i+1][j+1] == 1) live++;
                    if(board[i+1][j] == 1) live++;
                }
                if(j > 0 && board[i][j-1] == 1) live++;
                if(j < n-1 && board[i][j+1] == 1) live++;
                count[i][j] = live;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1){
                    int live = count[i][j];
                    if(live < 2 || live > 3) board[i][j] = 0;
                } else {
                    if(count[i][j] == 3) board[i][j] = 1;
                }
            }
        }
    }
}