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

// two end search can reduce the time
// previously we only go through all in begins set
// now if begins set > ends set, we swap them.
// so it means we are doing the same step two sides, 
// faster!
// 31ms 95%
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        
        Set<String> begins = new HashSet<>();
        Set<String> ends = new HashSet<>();
        begins.add(beginWord);
        ends.add(endWord);
        
        int len = 1; // it includes itself by given example
        while (begins.size() != 0 && ends.size() != 0) { //if ends is empty means we have found the endWord
            if (begins.size() > ends.size()) {
                Set<String> tmp = begins;
                begins = ends;
                ends = tmp;
            }
            dict.removeAll(begins);
            dict.removeAll(ends);

            Set<String> next = new HashSet<>();
            for (String w : begins) {
                char[] chars = w.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    for (char cur = 'a'; cur <= 'z'; cur++) {
                        if (cur == tmp) {
                            continue;
                        }
                        chars[i] = cur;
                        String word = String.valueOf(chars);
                        if (ends.contains(word)) {
                            return len + 1;
                        }
                        if (dict.contains(word)) {
                            next.add(word);
                        }
                    }
                    chars[i] = tmp;
                }
            }
            begins = next;
            len++;
        }
        
        return 0;
    }
}