/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 25, 2017
 Problem:    course schedule II
 Difficulty: medium
 Notes:
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int edge_len = prerequisites.length;
        int[] edge = new int[edge_len];
        int[] edge_next = new int[edge_len];
        int[] last = new int [numCourses];
        int[] indegree = new int[numCourses];
        int mark = 0;
        for (int i = 0;i<numCourses;i++) last[i] = -1;
        for (int i = 0;i<numCourses;i++) indegree[i] = 0;
        for (int i = 0;i<edge_len;i++) {
            edge[mark] = prerequisites[i][0];
            indegree[prerequisites[i][0]]++;
            int x = prerequisites[i][1];
            edge_next[mark] = last[x];
            last[x] = mark;
            mark++;
        }
        int[] queue = new int [numCourses];
        int l = -1, r= -1;
        for (int i  =0;i<numCourses;i++) {
            if (indegree[i]==0) queue[++r] = i;
        }
        while (l<r) {
            l++;
            int now = queue[l];
            int edge_now = last[now];
            while (edge_now!=-1) {
                indegree[edge[edge_now]]--;
                if (indegree[edge[edge_now]]==0) 
                    queue[++r] = edge[edge_now];
                edge_now = edge_next[edge_now];
            }
        }
        if (r+1!=numCourses) 
            return new int[0]; 
        else return queue;
    }
}
