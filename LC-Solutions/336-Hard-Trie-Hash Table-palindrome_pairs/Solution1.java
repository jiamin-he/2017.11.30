/*
Author: Jiamin
Date: Dec 22, 2017
Problem: Palindrome Pairs

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

*/
 
// 170 ms  20%
// 可能取substring 然后去看是否palindorme 比 直接传 start end 去看是否palindrome快
// 因为每次都在很长的string里找start 和 end 然后挪 所以会慢！
// 改后 135ms 60%

// O(n*k^2)
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) map.put(words[i], i);
        
        for(int i = 0; i < words.length; i++) {
            // if there is an empty String, it can still be matched. ["a",""] --> [0,1],[1,0]
            for (int j = -1; j < words[i].length(); j++) {
                String cur = words[i];
                if(isPal(cur,0,j)) {
                    String pair = new StringBuilder(cur.substring(j+1)).reverse().toString();
                    // if substring index exceeds, return emtpy string
                    if(map.containsKey(pair) && map.get(pair) != i) res.add(Arrays.asList(map.get(pair),i));
                }
                if(j!=cur.length()-1 && isPal(cur,j+1,cur.length()-1) ) {
                    String pair = new StringBuilder(cur.substring(0,j+1)).reverse().toString();
                    if(map.containsKey(pair) && map.get(pair) != i) res.add(Arrays.asList(i,map.get(pair)));
                }
            }
        }
        return res;
    }
    
    public boolean isPal (String s, int start, int end) {
        if(start > end) return true;
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}