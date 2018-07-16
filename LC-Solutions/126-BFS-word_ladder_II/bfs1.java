/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 10, 2017
 Problem:    word ladder II
 Difficulty: hard
 Notes:
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
*/

// mine~ does not work 
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList == null || wordList.size() < 1) return res;
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;
        Queue<List<String>> q = new LinkedList<>();
        List<String> begin = new ArrayList<>();
        begin.add(beginWord);
        q.add(begin);
        int size = q.size();
        boolean flag = true;
        while(!q.isEmpty() && flag) {
            while(size > 0 ) {
                List<String> s = q.poll();
                for( String a: s) {
                    System.out.print (size + " " + " --> " + a);
                }
                System.out.println("\n");
                char[] temp = s.get(s.size()-1).toCharArray();
                for(int i = 0; i < temp.length; i++) {
                    char c = temp[i];
                    for(char change = 'a'; change<='z'; change++) {
                        temp[i] = change;
                        String snew = new String(temp);
                        if(dict.contains(snew)) {
                            List<String> tnew = new ArrayList<>(s);
                            tnew.add(snew);
                            q.add(tnew);
                            if(snew.equals(endWord)) {
                                res.add(tnew);
                                flag = false;
                            } 
                        }
                    }
                    temp[i] = c;
                }
                size--;
            }
            size = q.size();
        }
        return res;
    }
}