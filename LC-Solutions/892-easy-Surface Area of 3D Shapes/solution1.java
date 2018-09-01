/*
Author: Jiamin
Date: Aug 26, 2018
Problem: Surface Area of 3D Shapes
Difficulty: easy

On a N * N grid, we place some 1 * 1 * 1 cubes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Return the total surface area of the resulting shapes.

 

Example 1:

Input: [[2]]
Output: 10
Example 2:

Input: [[1,2],[3,4]]
Output: 34
Example 3:

Input: [[1,0],[0,2]]
Output: 16
Example 4:

Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 32
Example 5:

Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 46
 

Note:

1 <= N <= 50
0 <= grid[i][j] <= 50,2]]
Output: 46
 

Note:

1 <= N <= 50
0 <= grid[i][j] <= 50
 
*/

class Solution {
    public int surfaceArea(int[][] grid) {
        int res = 0;
        if(grid.length < 1 || grid[0].length < 1) return res;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int temp = 0;
                if(grid[i][j] > 0) temp+=2;
                if(i==0 || grid[i-1][j] < grid[i][j]) temp+= grid[i][j] - (i==0? 0: grid[i-1][j]);
                if(i== n-1 || grid[i+1][j] < grid[i][j]) temp+= grid[i][j] - (i==n-1? 0: grid[i+1][j]);
                if(j==0 || grid[i][j-1] < grid[i][j]) temp+= grid[i][j] - (j==0? 0: grid[i][j-1]);
                if(j== m-1 || grid[i][j+1] < grid[i][j]) temp+= grid[i][j] - (j==m-1? 0: grid[i][j+1]);
                res+= temp;
            }
        }
        return res;
    }
}