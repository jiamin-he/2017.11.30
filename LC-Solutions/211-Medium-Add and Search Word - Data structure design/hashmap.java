/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 9, 2018
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

// 8% 204ms 
// bfs
class TrieNode {
    int val;
    boolean end;
    TrieNode[] next;
    
    public TrieNode() {
        next = new TrieNode[26];
        end = false;
    }
    
    public TrieNode(int v) {
        val = v;
        next = new TrieNode[26];
        end = false;
    }
}

class WordDictionary {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] sc = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < sc.length; i++) {
            if(cur.next[sc[i]-'a'] == null) {
                cur.next[sc[i]-'a'] = new TrieNode(sc[i]-'a');
            }
            cur = cur.next[sc[i]-'a'];
            if(i == sc.length -1) {
                cur.end = true;
            }
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Queue<TrieNode> q = new ArrayDeque<>();
        char[] sc = word.toCharArray();
        TrieNode cur = root;
        q.offer(cur);
        int i = 0;
        for(; i < sc.length; i++) {
            int size = q.size();
            if(sc[i] == '.'){
                while(size-- > 0) {
                    TrieNode curQ = q.poll();
                    for(TrieNode temp: curQ.next) {
                        if(temp != null) {
                            if(i == sc.length-1 && temp.end) return true;
                            q.offer(temp);
                        }
                    }
                }   
            } else {
                while(size-- > 0) {
                    TrieNode curQ = q.poll();
                    if(curQ.next[sc[i]-'a'] != null) {
                        if(i == sc.length-1 && curQ.next[sc[i]-'a'].end) return true;
                        q.offer(curQ.next[sc[i]-'a']);
                    }
                }
            }
            if(q.isEmpty()) return false;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// dfs
// 142ms
// 35%
class WordDictionary {
    class Node {
        private boolean isEnd;
        private char letter;
        private Node[] children;
        public Node (char c, boolean end) {
            isEnd = end;
            letter = c;
            children = new Node[26];
            //Arrays.fill (children, null);
        }
        public void addChild (Node child) {
            children[child.letter - 'a'] = child;
        }
        public Node getChild (char c) {
            return children[c-'a'];
        }
    }
    
    private Node root;

        /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node ('a', false);
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        int i = 0;
        for (i = 0; i<word.length(); ++i) {
            Node n = cur.getChild (word.charAt(i));
            if (n == null) {
                n = new Node (word.charAt(i), false);
                cur.addChild (n);
            }
            cur = n;
        }
        if (i == word.length() && cur.isEnd == false) cur.isEnd = true;
    }
    /*
    a.d
    root 0
    a   1
    d   2
    */
    private boolean searchWord (String word, Node start, int index) {
        //System.out.println ("current index is " + index);
            if (index >= word.length()) return start.isEnd;
            Node cur = start;
            char c = word.charAt (index);
            if (c == '.') {
                //if (index == word.length() - 1) return cur.isEnd;
                for (Node child: cur.children) {
                    if (child != null) {
                        //System.out.println ("searching " + cur.letter +" child " + child.letter);
                        if (searchWord (word, child, index + 1))
                            return true;
                    }
                }
                return false;
            } else {
                Node n = cur.getChild (c);
                //System.out.println ("getting child of " + cur.letter + " node is null?"  + n);
                if (n == null) return false;
                //System.out.println ("gettting child is " + n.letter);
                //if (index == word.length() - 1) return n.isEnd;
                return searchWord (word, n, index + 1);
            }
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord (word, root, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */