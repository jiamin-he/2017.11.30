/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    Graph Valid Tree
 Difficulty: medium
 Notes:
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

*/


// 2ms 50%
class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for( int[] edge: edges){
            if(!dsu.union(edge[0],edge[1])) return false;
        }
        boolean flag = true;
        if(dsu.count() > 1) return false;
        return true;
    }
    
    class DSU {
        int[] rank;
        int[] parent;
        
        public DSU(int N) {
            rank = new int[N];
            parent = new int[N];
            for(int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        
        public int count() {
            int count = 0;
            for(int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count;
        }
        
        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public boolean union(int x, int y) {
            int xp = find(x), yp = find(y);
            if(xp == yp) return false;
            if (rank[xp] < rank[yp]) {
                parent[xp] = yp;
            } else if (rank[xp] > rank[yp]) {
                parent[yp] = xp;
            } else {
                parent[xp] = yp;
                rank[yp]++;
            }
            return true;
        }
    }
}