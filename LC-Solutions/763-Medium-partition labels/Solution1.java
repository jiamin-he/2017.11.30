/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 13, 2017
 Problem:    Partition Labels
 Difficulty: Medium
 Notes:
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] start = new int[26];
        int[] end = new int[26];
        for(int i = 0; i < 26; i++) {
            start[i] = S.indexOf('a'+i);
            end[i] = S.lastIndexOf('a'+i);
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0, e = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < 26; ) {
            while(start[i] == -1) i++;
            s = start[i++];
            while(i> 0 && i < 26 && start[i] <= end[i-1]) i++;
            e = end[i-1];
            // System.out.println(S.substring(s,e+1));
            res.add(e-s+1);
        }
        return res;
    }
}