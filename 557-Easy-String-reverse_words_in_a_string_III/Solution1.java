/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 02, 2017
 Problem:    reverse words in a string iii
 Difficulty: Easy
 Notes:

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

 */

// 30ms 30%
class Solution {
    public String reverseWords(String s) {
        String[] splited = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < splited.length; i++){
            StringBuilder str = new StringBuilder();
            str.append(splited[i]);
            res.append(str.reverse());
            res.append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}


//27ms 32%
class Solution {
    public String reverseWords(String s) {
        String[] splited = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for(String str: splited){
            str = new StringBuilder(str).reverse().toString();
            res.append(str+" ");
        }
        return res.toString().trim();
    }
}