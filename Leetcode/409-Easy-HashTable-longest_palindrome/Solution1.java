/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 22, 2017
 Problem:    longest palindrome
 Difficulty: esay
 Notes:

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.


*/
// 10ms 84%
class Solution {
    public int longestPalindrome(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];
        char[] sc = s.toCharArray();
        for (char c: sc) {
            if(c >= 'a') lower[c-'a']++;
            else upper[c-'A']++;
        }
        int sum = 0;
        for(int i = 0; i < 26; i++) {
            sum += (upper[i]/2)*2;
            sum += (lower[i]/2)*2;
        }
        return sum == sc.length? sum: sum+1;
    }
}

//23ms 20%
class Solution {
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }  
}