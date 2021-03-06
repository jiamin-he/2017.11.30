/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 21, 2017
 Problem:    Courses Schedule
 Difficulty: Medium
 Notes:

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.

*/
import java.util.*;

class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<2) return true;
        int[] pre = new int[numCourses];
        Arrays.fill(pre, -1);
        for(int[] p : prerequisites){
            int tmp = p[1];
            while(tmp>=0){                
                tmp=pre[tmp];
                if(tmp==p[0])
                    return false;
            }
            pre[p[0]]=p[1];
        }
        return true;
    }

    public boolean dfs(int i, List<List<Integer>> graph, boolean[] visited){
        if(visited[i]) return false;
        else visited[i] = true;
        for(int j = 0; j < graph.get(i).size(); j++)
            if(!dfs(graph.get(i).get(j),graph,visited)) return false;
        visited[i] = false;
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = new int[][]{{1,0},{2,1}};
        Solution3 s1 = new Solution3();
        System.out.println(s1.canFinish(numCourses, prerequisites));
    }
}
