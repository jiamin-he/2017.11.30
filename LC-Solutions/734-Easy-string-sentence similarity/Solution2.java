/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 25, 2017
 Problem:    Sentence Similarity
 Difficulty: Easy
 Notes:
Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.

However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
*/


// brute-force 但是竟然很快？？？最快？？？ 99%？？？？
class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        for (int i = 0; i < words1.length; i++) {
            if (!similar(words1[i], words2[i], pairs)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean similar(String s1, String s2, String[][] pairs) {
        if (s1.equals(s2)) return true;
        for (String[] pair : pairs) {
            if (pair[0].equals(s1) && pair[1].equals(s2)) {
                return true;
            }
            if (pair[0].equals(s2) && pair[1].equals(s1)) {
                return true;
            }
        }
        return false;
    }
}