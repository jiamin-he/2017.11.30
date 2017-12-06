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
    int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //dfs
        
        int[] res = new int[numCourses];
        int[] visited = new int[numCourses]; // 0: not visited
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int index = 0;
        
        for(int i = 0; i < prerequisites.length; i++){
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            Set<Integer> temp = new HashSet<>();
            if(map.containsKey(pre)){
                temp = map.get(pre);
            }
            if(!temp.contains(cur)){
                temp.add(cur);
                map.put(pre,temp);    
            }
        }
        
        for(int i = 0;i < numCourses ;i++){
            if(visited[i] == 0){
                if(!dfs(i,map,visited,res,numCourses)) return new int[0];
            } 
        }
        
        return res;
    }
    
    public boolean dfs(int i,Map<Integer,Set<Integer>> map,int[] visited, int[] res, int numCourses ){
        visited[i] = 1; //visiting
        if(map.containsKey(i)){
            for(Integer i2 : map.get(i)){
                if(visited[i2] == 1) return false;
                if(visited[i2] == 0 && !dfs(i2,map,visited,res,numCourses)) return false;    
            }
        }
        res[numCourses-index-1] = i;
        index++;
        visited[i] = 2;
        return true;
    }
}
