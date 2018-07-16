/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 04, 2018
 Problem:    Rearrange String k Distance Apart
 Difficulty: Hard
 Notes:

Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
s = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
Example 2:
s = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.
Example 3:
s = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.
*/

// 11ms, 100%
// O(26n) --> O(n)
class Solution {
    public String rearrangeString(String s, int k) {
        char[] sc = s.toCharArray();
        int[] candidate = new int[26];
        int[] validIndex = new int[26];
        for(char c: sc){
            candidate[c-'a']++;
        }
        // construct the string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int index = findIndex(i,candidate,validIndex);
            if(index == -1) return "";   
            else {
                sb.append((char)('a'+index));
                candidate[index]--;
                validIndex[index] = i+k;
            }
        }
        return sb.toString();
        
    }
    
    public int findIndex(int curPosition, int[] candidate, int[] validIndex){
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< candidate.length; i++){
            if (candidate[i]>0 && candidate[i] > max && curPosition>=validIndex[i] ) {
                max = candidate[i];
                index = i;
            }
        }
        return index;
    }
}