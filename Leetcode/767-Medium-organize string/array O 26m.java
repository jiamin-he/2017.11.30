/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 21, 2017
 Problem:    Organize String
 Difficulty: Medium
 Notes:

Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
*/


// 9ms 62 test cases
// O(26N)
class Solution {
    public String reorganizeString(String S) {
        int l = S.length(),max = 0,index = -1;
        int[] table = new int[26];
        char[] stc = S.toCharArray();
        if(l <= 2){
            return (stc[0] != stc[l-1]) ? S : "";
        }
        for(char c:stc){
            table[c-'a']++;
        }
        char[] res = new char[l];
        for(int i=0;i<l;i++){      
            max = 0;
            index = -1;
            for(int j=0;j<26;j++){
                if(table[j] > max && (i == 0 || j != res[i-1] - 'a')){
                    max = table[j];
                    index = j;
                }
            }
            if(max == 0)
                return "";
            res[i] = (char)(index + 'a');
            table[index]--;
        }
        return new String(res);
    }
}