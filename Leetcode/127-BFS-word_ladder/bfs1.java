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

// TLE 
// 每一层是换一个字母 对每个字母26个都换一次 复杂度很高！
// n个字母 则每一层是26n * q.size
// 一共层数是返回值的那个东东 
// 乘起来很大啊！！
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        if(wordList == null || wordList.size() < 1) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int size = q.size();
        while(!q.isEmpty()) {
            level++;
            while(size > 0) {
                String s = q.poll();
                size--;
                char[] temp = s.toCharArray();
                for(int i = 0; i < temp.length; i++) {
                    char c = temp[i];
                    for(char change = 'a'; change<='z'; change++) {
                        temp[i] = change;
                        String snew = new String(temp);
                        if(wordList.contains(snew)&& !visited.contains(snew)) {
                            if(snew.equals(endWord)) return level;
                            q.add(snew);
                            visited.add(snew);
                        }
                    }
                    temp[i] = c;
                }
            }
            size = q.size();
        }
        return 0;
    }
}

// 118 ms 56%
// converting the List to a HashSet will not TLE!!
// ArrayList lookup/remove O(n) insertion O(1)
// while HashSet lookup/remove/insertion O(1)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        if(wordList == null || wordList.size() < 1) return 0;
        // Set<String> dict = new HashSet<>();
        // for(String w: wordList) {
        //     dict.add(w);
        // }
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int size = q.size();
        while(!q.isEmpty()) {
            level++;
            while(size > 0) {
                String s = q.poll();
                size--;
                char[] temp = s.toCharArray();
                for(int i = 0; i < temp.length; i++) {
                    char c = temp[i];
                    for(char change = 'a'; change<='z'; change++) {
                        temp[i] = change;
                        String snew = new String(temp);
                        if(dict.contains(snew)&& !visited.contains(snew)) {
                            if(snew.equals(endWord)) return level;
                            q.add(snew);
                            visited.add(snew);
                        }
                    }
                    temp[i] = c;
                }
            }
            size = q.size();
        }
        return 0;
    }
}

// to save space, we can remove the visited hashset
// instead, we directly remove the visited elements from the dictionary.
// 96ms 75% save space and time
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        if(wordList == null || wordList.size() < 1) return 0;
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int size = q.size();
        while(!q.isEmpty()) {
            level++;
            while(size > 0) {
                String s = q.poll();
                size--;
                char[] temp = s.toCharArray();
                for(int i = 0; i < temp.length; i++) {
                    char c = temp[i];
                    for(char change = 'a'; change<='z'; change++) {
                        temp[i] = change;
                        String snew = new String(temp);
                        if(dict.contains(snew)) {
                            if(snew.equals(endWord)) return level;
                            q.add(snew);
                            dict.remove(snew);
                        }
                    }
                    temp[i] = c;
                }
            }
            size = q.size();
        }
        return 0;
    }
}