/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 30, 2018
 Problem:    Word Subsets
 Difficulty: Medium
 Notes:
We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 

Return a list of all universal words in A.  You can return the words in any order.

 

Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
 

Note:

1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].
 */


// 建议： 可以写一个count 的helper function啦啦啦～
class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        if(A.length < 1 || B.length < 1) return res;
        
        int[] charCount = new int[26];
        for(String b: B) {
            int[] tempCount = new int[26];
            char[] bs = b.toCharArray();
            for(char bc: bs) {
                tempCount[bc-'a']++;
            }
            for(int i = 0; i < 26; i++) {
                if(charCount[i] < tempCount[i]) {
                    charCount[i] = tempCount[i];
                }
            }
        }
        
        for(String a: A) {
            int[] tempCount = new int[26];
            char[] as = a.toCharArray();
            for(char ac: as) {
                tempCount[ac-'a']++;
            }
            boolean valid = true;
            for(int i = 0; i < 26 && valid; i++) {
                if(tempCount[i] < charCount[i]) {
                    valid = false;
                }
            }
            if(valid) {
                res.add(a);
            }
        }
        return res;
    }
}