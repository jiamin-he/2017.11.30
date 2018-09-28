/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 25, 2018
 Problem:    Add and Search Word - Data structure design
 Difficulty: Medium
 Notes:

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

*/


// space: O(27^maxLength)
// time: add -- O(2^curLength), search -- O(curLength)
// 这样其实空间复杂度会很高哦！在LC里会memory limit exceed
class WordDictionary {
    
    class TrieNode {
        boolean end;
        char val;
        TrieNode[] next;
        
        public TrieNode(boolean e, char v) {
            end = e;
            val = v;
            next = new TrieNode[27];
        }
        
        public void addWord(char[] wc, int i) {
            if(i >= wc.length) return;
            int index = wc[i] - 'a';
            if(next[index] == null) {
                next[index] = new TrieNode(false, wc[i]);
            }
            if(next[26] == null) {
                next[26] = new TrieNode(false, '.');
            }
            if(i == wc.length - 1) {
                next[index].end = true;
                next[26].end = true;
            }
            next[index].addWord(wc, i+1);
            next[26].addWord(wc, i+1);
        }
        
        public boolean searchNext (char c, boolean end) {
            int index = c=='.'? 26: c- 'a';
            if(next[index] == null) return false;
            if(end) {
                if(!next[index].end) return false;
            }
            return true;
        }
        
        public boolean searchWord(char[] wc, int i) {
            TrieNode nextChar = wc[i] == '.'? next[26]: next[wc[i] - 'a'];
            if(nextChar == null) return false;
            else {
                if(i == wc.length - 1) {
                    return nextChar.end;
                } else {
                    return nextChar.searchWord(wc, i+1);
                }
            }
        }
        
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(false, ' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] wc = word.toCharArray();
        root.addWord(wc,0);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] wc = word.toCharArray();
        return root.searchWord(wc, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */