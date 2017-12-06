/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 25, 2017
 Problem:    alien dictionary
 Difficulty: hard
 Notes:

There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,

[
  "z",
  "x"
]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,

[
  "z",
  "x",
  "z"
]
The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

*/

class Solution {
    public String alienOrder(String[] words) {
        //bfs
        
        //build graph
        Map<Integer,Integer> inDegree = new HashMap<>();
        Map<Integer,Set<Integer>> adj = new HashMap<>();
        for(String s: words){
            for(char c: s.toCharArray()){
                inDegree.put(c-'a',0);
            }
        }
        for(int i = 0; i < words.length -1; i++){
            String cur = words[i];
            String nxt = words[i+1];
            int length = Math.min(cur.length(),nxt.length());
            for(int j = 0; j < length; j++){
                int a = cur.charAt(j)-'a';
                int b = nxt.charAt(j)-'a';
                Set<Integer> temp = new HashSet<>();
                if (a!=b){
                    if (adj.containsKey(a)) temp = adj.get(a);
                    if(!temp.contains(b)){
                        temp.add(b);
                        inDegree.put(b,inDegree.get(b)+1);
                        adj.put(a,temp);
                    }
                    break;
                }
            }
            if(cur.length() > nxt.length() && nxt.equals(cur.substring(0,nxt.length())))
                return "";
        }
        
        // queue
        Queue<Integer> q = new LinkedList<>();
        String res = "";
        for (Integer i: inDegree.keySet()){
            if(inDegree.get(i) == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int i = q.poll();
            res += (char)(i+'a');
            if(adj.containsKey(i)){
               for (Integer i2 : adj.get(i)){
                inDegree.put(i2,inDegree.get(i2)-1);
                if(inDegree.get(i2) == 0) q.offer(i2);
                } 
            }
        }
        if(res.length() != inDegree.size()) return "";
        return res;
    }
}

