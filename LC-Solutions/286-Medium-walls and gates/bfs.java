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

// 16ms 44%
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length ==0 || rooms[0].length == 0) return;
        int r = rooms.length, c = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(rooms[i][j] == 0) {
                    q.offer(new int[] {i,j});
                }
            }
        }
        int level = 1, size = q.size();
        while(!q.isEmpty()) {
            while(size--> 0) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                if(x == 1 && y == 0) System.out.println(level);
                if(x < r-1 && rooms[x+1][y] == Integer.MAX_VALUE) {
                    rooms[x+1][y] = level;
                    q.offer(new int[]{x+1,y});
                } 
                if(x > 0 && rooms[x-1][y] == Integer.MAX_VALUE) {
                    rooms[x-1][y] = level;
                    q.offer(new int[]{x-1,y});
                } 
                if(y > 0 && rooms[x][y-1] == Integer.MAX_VALUE) {
                    rooms[x][y-1] = level;
                    q.offer(new int[]{x,y-1});
                }
                if(y < c -1 && rooms[x][y+1] == Integer.MAX_VALUE) {
                    rooms[x][y+1] = level;
                    q.offer(new int[] {x,y+1});
                }
            }
            size = q.size();
            level++;
        }
    }
}