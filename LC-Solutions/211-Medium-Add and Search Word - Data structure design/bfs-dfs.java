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

// 140ms
// 40%
class WordDictionary {
    Map<Integer, List<String>> map;//the key is the length of the string, the list stores the string with this length
    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>(); 
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int index = word.length();
	    if (!map.containsKey(index)) {
	        List<String> list = new ArrayList<>();
	        list.add(word);
		    map.put(index, list);
	    } else {
		    map.get(index).add(word);
	    }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            return false;
        }
  
        List<String> list = map.get(index);
        for(String s : list) { 
            if(isSame(s, word)) { // when word has '.'
                return true;
            }
        }
        return false;
    }

    public boolean isSame(String s, String word) { // word has '.'
        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
}