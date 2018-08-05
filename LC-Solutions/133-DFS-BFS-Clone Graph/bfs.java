/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 24, 2017
 Problem:    Clone Graph
 Difficulty: Medium
 Notes:
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

*/

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        HashMap<Integer, UndirectedGraphNode> map = new HashMap(); 
        map.put(newNode.label, newNode);
        LinkedList<UndirectedGraphNode> queue = new LinkedList();
        queue.add(node); 
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.pop(); 
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) { 
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label)); 
            }
        }
        return newNode;
    }
}


// Aug 3rd 2018 review
// 11ms 2%
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> candidates = new LinkedList<>();
        Map<Integer, UndirectedGraphNode> finished = new HashMap<>();
        if(node == null) return null;
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        candidates.offer(node);
        finished.put(clone.label, clone);
        while(!candidates.isEmpty()) {
            UndirectedGraphNode temp = candidates.poll();
            for(UndirectedGraphNode neighbor: temp.neighbors) {
                if(!finished.containsKey(neighbor.label)) {
                    finished.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    candidates.offer(neighbor);
                }
				// 把这一句改一下就会快一些 见下面一个version
                finished.get(temp.label).neighbors.add(finished.get(neighbor.label));
            } 
        }
        return clone;
    }
}

// 不要每次都去访问hashmap 这样会快一些
// 6ms 21%
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> candidates = new LinkedList<>();
        Map<Integer, UndirectedGraphNode> finished = new HashMap<>();
        if(node == null) return null;
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        candidates.offer(node);
        finished.put(clone.label, clone);
        while(!candidates.isEmpty()) {
            UndirectedGraphNode temp = candidates.poll();
            UndirectedGraphNode correspond = finished.get(temp.label);
            for(UndirectedGraphNode neighbor: temp.neighbors) {
                if(!finished.containsKey(neighbor.label)) {
                    finished.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    candidates.offer(neighbor);
                }
                correspond.neighbors.add(finished.get(neighbor.label));
            } 
        }
        return clone;
    }
}