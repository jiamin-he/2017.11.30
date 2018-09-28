/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 26, 2018
 Problem:    Find All Anagrams in a String
 Difficulty: Easy
 Notes:
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

// sliding window 
// o(N)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < 1 || p.length() < 1) return res;
        
        int[] map = new int[26];
        char[] pc = p.toCharArray();
        for(char c : pc){
            map[c-'a']++;
        }

        int start = 0;
        char[] sc = s.toCharArray();
        for(int i = 0; i < sc.length; i++) {
            int index = sc[i] - 'a';
            map[index]--;
            if(map[index] < 0) {
                while(map[index] < 0) {
                    map[sc[start] - 'a']++;
                    start++;
                }
            } else if(map[index] == 0 && i - start + 1 == pc.length) {
                res.add(start);
                map[sc[start] - 'a']++;
                start++;
            }
        }
        return res;
    }
}
