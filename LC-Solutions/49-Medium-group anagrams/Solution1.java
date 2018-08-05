/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 4, 2018
 Problem:    Group Anagrams
 Difficulty: medium
 Notes:
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

// 16ms 83%
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String str: strs) {
            char[] sc = str.toCharArray();
            Arrays.sort(sc);
            String sortedStr = new String(sc);
            if(!res.containsKey(sortedStr)) {
                res.put(sortedStr, new ArrayList<String>());
            }
            res.get(sortedStr).add(str);
        }
        List<List<String>> finalRes = new ArrayList<>();
        for(String s: res.keySet()) {
            finalRes.add(res.get(s));
        }
        return finalRes;
    }
}