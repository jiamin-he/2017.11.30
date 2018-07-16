/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 14, 2017
 Problem:    Walls and Gates
 Difficulty: Medium
 Notes:
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4


*/

// 8ms 78%
class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col <rooms[0].length; col++) {
                if (rooms[row][col] == 0)
                    dfs(rooms, row, col, 0);
            }
        }
    }
    
    private void dfs(int[][] rooms, int row, int col, int distance) {
        if (row < 0 || col < 0
            || row >= rooms.length || col >= rooms[0].length
            || rooms[row][col] < distance) {
            return;
        }
        rooms[row][col] = distance;
        dfs(rooms, row+1, col, distance+1);
        dfs(rooms, row-1, col, distance+1);
        dfs(rooms, row, col+1, distance+1);
        dfs(rooms, row, col-1, distance+1);
    }
}