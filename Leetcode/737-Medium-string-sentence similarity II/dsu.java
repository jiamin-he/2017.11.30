/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 04, 2017
 Problem:    Sentence Similarity II
 Difficulty: Medium
 Notes:
Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.

Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
*/

// 47 ms 93.72%
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        DSU dsu = new DSU(2 * pairs.length);
        for( String[] pair: pairs) {
            for(String s: pair){
                if(!map.containsKey(s)) {
                    map.put(s,count++);
                }
            }
            dsu.union(map.get(pair[0]),map.get(pair[1]));
        }
        
        for(int i = 0; i < words1.length; i++) {
            if(words1[i].equals(words2[i])) continue;
            if(!map.containsKey(words1[i]) || !map.containsKey(words2[i]) 
               || dsu.find(map.get(words1[i])) != dsu.find(map.get(words2[i]))) 
                return false;
        }
        return true;
    }
    
    class DSU {
        int[] rank;
        int[] parent;
        
        public DSU(int N) {
            parent = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if(x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }
        
        public void union(int x, int y) {
            int xp = find(x), yp = find(y);
            if(rank[xp] < rank[yp]) {
                parent[xp] = yp;
            } else if (rank[xp] > rank[yp]) {
                parent[yp] = xp;
            } else {
                parent[xp] = yp;
                rank[yp]++;
            }
        }

        // 可以把上面那段优化的 改成 下面这段没优化的 由于测试样例少 只慢了1ms
        // 当然优化了自然最好啦哈哈哈
        // public void union(int x, int y) {
        //     parent[find(x)] = find(y);
        // }
    }
}