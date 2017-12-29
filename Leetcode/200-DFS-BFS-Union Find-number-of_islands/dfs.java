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