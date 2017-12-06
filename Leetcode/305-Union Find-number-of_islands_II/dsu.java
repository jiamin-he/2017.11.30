/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 05, 2017
 Problem:    Number of Islands ii
 Difficulty: Hard
 Notes:
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?

*/


//dsu
//21ms 51.91%
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if(positions == null || positions.length == 0 || positions[0].length == 0) return new ArrayList<>();
        int count = 0;
        DSU dsu = new DSU(m*n+1);
        List<Integer> res = new ArrayList<>();
        int[][] move = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] p : positions) {
            count++;
            dsu.parent[index(p[0],p[1],n)] = index(p[0],p[1],n);
            for(int[] mo: move) {
                int x = p[0] + mo[0];
                int y = p[1] + mo[1];
                if( x < m && y < n && x >= 0 && y >= 0 && dsu.parent[index(x,y,n)] != 0) {
                   if(dsu.union(index(p[0],p[1],n),index(x,y,n))) {
                       count--;
                   }
                }
            }
            res.add(count);
        }
        return res;
    }
    
    public int index(int x, int y, int c) {
        return c*x + y + 1;
    }
    
    class DSU {
        int[] parent;
        int[] rank;
        
        public DSU(int N) {
            parent = new int[N];
            rank = new int[N];
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

