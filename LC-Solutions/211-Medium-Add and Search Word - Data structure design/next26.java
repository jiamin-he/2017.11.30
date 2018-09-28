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


// space: O(26^maxLength)
// time: add -- O(curLength), search -- O(26^curLength)
// 这样search的时候复杂度会很高哦！
// compared with next27 的solution，取决于 是add 操作更多还是 search 操作更多
class WordDictionary {
    
    class TrieNode {
        boolean end;
        char val;
        TrieNode[] next;
        
        public TrieNode(boolean e, char v) {
            end = e;
            val = v;
            next = new TrieNode[26];
        }
        
        public void addWord(char[] wc, int i) {
            if(i >= wc.length) return;
            int index = wc[i] - 'a';
            if(next[index] == null) {
                next[index] = new TrieNode(false, wc[i]);
            }
            if(i == wc.length - 1) {
                next[index].end = true;
            }
            next[index].addWord(wc, i+1);
        }
        
        public boolean searchWord(char[] wc, int i) {
            boolean res = false;
            if(wc[i] == '.') {
                
               for(int j = 0; j < 26; j++) {
                    if(next[j] != null) {
                        if(i == wc.length - 1) {
                            if(next[j].end) {
                                res = true;
                                break;
                            }
                        } else if(next[j].searchWord(wc, i+1)) {
                            res = true;
                            break;
                        } 
                    }
                } 
                
            } else {
                TrieNode nextChar = next[wc[i] - 'a'];
                if(nextChar != null) {
                    if(i == wc.length - 1) {
                        res = nextChar.end;
                    } else {
                        res = nextChar.searchWord(wc, i+1);
                    }
                } 
            }
            return res;
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