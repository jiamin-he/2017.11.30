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
        //dfs
        
        //build graph
        Map<Integer,Set<Integer>> adj = new HashMap<>();
        int[] state = new int[26]; // 0 initiate
        StringBuilder sb = new StringBuilder();
        
        for(String s: words){
            for(char c: s.toCharArray()){
                state[c-'a'] = 1; // 1 exist
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
                        adj.put(a,temp);
                    }
                    break;
                }
            }
            if(cur.length() > nxt.length() && nxt.equals(cur.substring(0,nxt.length())))
                return "";
        }
        
        for(int i = 0; i < 26; i++){
            if(state[i] == 1) {
                if (!dfs(i,sb,state,adj)) return "";
            }
        }
        return sb.reverse().toString();     
    }
    
    
    public boolean dfs(int i,StringBuilder sb,int[] state, Map<Integer, Set<Integer>> adj){
        state[i] = 2; // 2 visiting
        if(adj.containsKey(i)){
            for(Integer i2 : adj.get(i)){
                if(state[i2] == 2) return false;
                if(state[i2]== 1 && !dfs(i2,sb,state, adj)) return false;
            }
        }
        sb.append((char)(i+'a'));
        state[i]=3;
        return true;
    }
}

