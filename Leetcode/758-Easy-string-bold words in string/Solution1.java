/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    bold words in string
 Difficulty: Easy
 Notes:

Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.

The returned string should use the least number of tags possible, and of course the tags should form a valid combination.

For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

Note:

words has length in range [0, 50].
words[i] has length in range [1, 10].
S has length in range [0, 500].
All characters in words[i] and S are lowercase letters.

*/


// 27ms
class Solution {
    public String boldWords(String[] words, String S) {
        if(S == null || S.length() == 0) return S;
        int len = S.length();
        boolean[] flag = new boolean[len];
        for(String word: words) {
            int sLen = word.length();
            int first = S.indexOf(word);
            int last = S.lastIndexOf(word);
            while (first != -1 && first <= last) {
                for(int i = 0; i < sLen; i++) {
                    flag[first+i] = true;
                }
                first = S.indexOf(word,first+1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            if(flag[i]) {
                sb.append("<b>" + S.charAt(i) + "</b>");
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString().replaceAll("</b><b>", "");
    }
}