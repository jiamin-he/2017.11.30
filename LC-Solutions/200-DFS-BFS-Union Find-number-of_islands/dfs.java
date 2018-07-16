/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 24, 2017
 Problem:    Number of Islands
 Difficulty: Medium
 Notes:
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

*/


// 7ms 46%
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    fill(grid, i, j);
                    count++;   
                }
            }
        }
        return count;
    }
    
    private void fill(char[][] grid, int r, int c){
        if(r>= grid.length || c>=grid[0].length || r<0 || c<0 || grid[r][c] != '1') return;
        grid[r][c] = '0';
        fill(grid,r+1,c);
        fill(grid,r-1,c);
        fill(grid,r,c+1);
        fill(grid,r,c-1);
    }
}

// Jan 1st Review
// 7ms 46%
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return count;
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j, row, col);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j, int row, int col) {
        grid[i][j] = '0';
        if(j < col - 1 && grid[i][j+1] == '1' ) {
            dfs(grid, i, j+1, row, col);
        }
        if(i < row - 1 && grid[i+1][j] == '1') {
            dfs(grid, i+1, j, row, col);
        }
        if(i > 0 && grid[i-1][j] == '1') {
            dfs(grid, i-1,j,row,col);
        }
        if(j > 0 && grid[i][j-1] =='1') {
            dfs(grid, i,j-1,row,col);
        }
    }
}