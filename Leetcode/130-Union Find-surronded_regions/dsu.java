/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    Surrounded Regions
 Difficulty: Medium
 Notes:
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

*/


//dsu
//17ms 11%
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return ;
        int r = board.length, c = board[0].length;
        DSU dsu = new DSU(r*c+1);
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == 'O') {
                    if(i == 0 || j == 0 || i == r-1 || j == c-1) {
                        dsu.union(i*c+j, r*c);
                    }
                    if(j < c - 1 && board[i][j+1] == 'O') {
                        dsu.union(i*c+j, i*c+j+1);
                    }
                    if(i < r - 1 && board[i+1][j] == 'O') {
                        dsu.union(i*c+j, i*c+j+c);
                    }
                }
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!dsu.isUnion(i*c+j, r*c)) {
                    board[i][j] = 'X';
                }
            }
        }
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
        
        public void union(int x, int y) {
            int xp = find(x), yp = find(y);
            if(rank[xp] < rank[yp]) {
                parent[xp] = yp;
            } else if(rank[xp] > rank[yp]) {
                parent[yp] = xp;
            } else {
                parent[xp] = yp;
                rank[xp]++;
            }
        }
        
        public boolean isUnion(int x, int y) {
            return find(x) == find(y);
        }
    }
}

