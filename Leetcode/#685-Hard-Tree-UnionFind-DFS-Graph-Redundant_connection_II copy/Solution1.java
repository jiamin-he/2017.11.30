/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 8, 2017
 Problem:    redundant connection ii
 Difficulty: hard
 Notes:
In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
*/

import java.util.*;

class Solution1 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length+1];
        int l = 0, r = 0, lparent = 0, rparent = 0;
        int[] remove1 = {0,0}, remove2 = {0,0};
        boolean flag = false;
        for(int i = 0; i < edges.length; i++){
            l = edges[i][0];
            r = edges[i][1];
            if(parents[r] == 0) parents[r] = l;
            else {
                remove1[0] = parents[r];
                remove1[1] = r;
                remove2[0] = l; 
                remove2[1] = r; 
                edges[i][1] = 0; // remove this edge.
                flag = true;
                break;
            }
        }

        for(int i = 0; i < parents.length; i++) parents[i] = i;
        for(int i = 0; i < edges.length; i++){
            l = edges[i][0];
            r = edges[i][1];
            if(r == 0) continue;
            lparent = findParent(l,parents);
            rparent = findParent(r,parents);
            if(lparent == rparent) {
                if(flag) return remove1;
                else return edges[i];
            } else{
                parents[rparent] = lparent;
            }
        }
        return remove2;
    }

    public int findParent(int child, int[] parents){
        if(parents[child] == child) return child;
        parents[child] = findParent(parents[child], parents);
        return parents[child];
    }

    public static void main(String[] args) {
       
        
    }
}
