/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 18, 2018
 Problem:    LRU cache
 Difficulty: Hard
 Notes:

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 -- capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

// 173ms 10%
class Node {
        int key, val, cnt;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }


public class LFUCache {
    int capacity, size, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, LinkedHashSet<Integer>> countMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        }
        else {
            node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                LinkedHashSet<Integer> set = countMap.get(min);
                int last = set.iterator().next();
                nodeMap.remove(last);
                set.remove(last);
                size--;
            }
            size++;
            min = 1;
            LinkedHashSet<Integer> newSet = countMap.getOrDefault(node.cnt, new LinkedHashSet<>());
            newSet.add(node.key);
            countMap.put(node.cnt, newSet);
        }
    }
    
    private void update(Node node) {
        LinkedHashSet<Integer> set = countMap.get(node.cnt);
        set.remove(node.key);
        if (node.cnt == min && set.size() == 0) min++; 
        node.cnt++;
        LinkedHashSet<Integer> newSet = countMap.getOrDefault(node.cnt, new LinkedHashSet());
        newSet.add(node.key);
        countMap.put(node.cnt, newSet);
    }
}