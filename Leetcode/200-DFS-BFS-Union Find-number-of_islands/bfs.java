/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 22, 2017
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


//dsu
//12ms 15.45%
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int r = grid.length, c = grid[0].length;
        int count = 0;
        DSU dsu = new DSU(r*c);
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    if(j < c -1 && grid[i][j+1] == '1') {
                        if(dsu.union(i*c+j, i*c+j+1)) {
                            count--;
                        }
                    }
                    if(i < r -1 && grid[i+1][j] == '1') {
                        if(dsu.union(i*c+j, i*c+j+c)) {
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    class DSU {
        int[] parent;
        int[] rank;
        
        public DSU(int N) {
            parent = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if( parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        
        public boolean union(int x, int y) {
            int xp = find(x), yp = find(y);
            if(xp == yp) return false;
            if(rank[xp] < rank[yp]) {
                parent[xp] = yp;
            } else if(rank[xp] > rank[yp]) {
                parent[yp] = xp;
            } else {
                parent[xp] = yp;
                rank[xp]++;
            }
            return true;
        }
    }
}

