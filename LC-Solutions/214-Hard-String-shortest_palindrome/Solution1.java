/*
Author: Jiamin
Date: Dec 22, 2017
Problem: shortest palindrome

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".


*/

// 3ms 90%
// 我想到相似的思路 但是这个递归的实现方法很好！！！
// O(n^2)
class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        	//找到第一个使他不回文的位置
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}

// O(n^2)
// 300ms 23%
class Solution {
    public String shortestPalindrome(String s) {
        char[] sc = s.toCharArray();
        int index = 0;
        for(int i = sc.length - 1; i >= 0; i--) {
            if(isPalindrome(sc, 0, i)) {
                index = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = sc.length - 1; i > index; i--) {
            sb.append(sc[i]);
        }
        sb.append(s);
        return sb.toString();
    }
    public boolean isPalindrome(char[] sc, int start, int end) {
        while(start < end) {
            if(sc[start++] != sc[end--]) {
                return false;
            }
        }
        return true;
    }
}