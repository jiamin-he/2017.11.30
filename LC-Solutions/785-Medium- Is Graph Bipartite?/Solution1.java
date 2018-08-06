/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 05, 2018
 Problem:     Is Graph Bipartite?
 Difficulty: Medium
 Notes:
Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
 

Note:

graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
*/

// 6ms 52%
class Solution {
    public boolean isBipartite(int[][] graph) {
        if( graph == null || graph.length < 1) return false;
        int len = graph.length;
        int[] group = new int[len];
        for(int i = 0; i < len; i++) {
            if(group[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                group[i] = 1;
                q.offer(i);
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for( int j: graph[cur]) {
                        if(Math.abs(group[cur] + group[j]) > 1) return false;
                        if(group[j] == 0) q.offer(j);
                        group[j] = -group[cur];
                        
                    }
                } 
            }
        }
        
        return true;
    }
}

// dfs
// 5ms 75%
class Solution {
    public boolean isBipartite(int[][] graph) {
        int numNode = graph.length;
        int[] colors = new int[numNode];
        Arrays.fill(colors,-1);
        
        for(int i = 0;i < numNode;i++) {
            if(colors[i] == -1 && !isValid(graph,i,0,colors))
                return false;
        }
        return true;
    }
    
    public boolean isValid(int[][] graph,int i,int curColor,int[] colors) {
        if(colors[i] != -1)
            return colors[i] == curColor;
        colors[i] = curColor;
        for(int next :graph[i]) {
            if(!isValid(graph,next,1-curColor,colors))
                return false;
        }
        return true;
        
    }
}