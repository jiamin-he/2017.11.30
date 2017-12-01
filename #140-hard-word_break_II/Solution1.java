/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 29, 2017
 Problem:    Word Break II
 Difficulty: hard
 Notes:
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].



 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length()+1; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

//a better version (more efficient)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for(String word: wordDict){
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        dp[0] = true;
        for(int i = 1; i < s.length()+1; i++){
            for(int j = Math.max(0, i - maxLen); j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
