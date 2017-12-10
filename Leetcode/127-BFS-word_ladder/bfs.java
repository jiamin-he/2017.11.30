/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 10, 2017
 Problem:    word ladder
 Difficulty: medium
 Notes:
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null) return res;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            s = q.poll();
            if(isValid(s)) {
                res.add(s);
                found = true;
            }
            if(found) continue;
            char[] temp = s.toCharArray();
            for(int i = 0; i < temp.length; i++) {
                if(temp[i] == '(' || temp[i] == ')' ) {
                    String t = s.substring(0,i) + s.substring(i+1);
                    if(!visited.contains(t)) {
                        q.add(t);
                        visited.add(t);
                    }
                } else {
                    continue;
                }
            }  
        }
        return res;
    }
    
    public boolean isValid(String s) {
        int count = 0; 
        for(char c: s.toCharArray()) {
            if(c == '(') count++;
            if(c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}
