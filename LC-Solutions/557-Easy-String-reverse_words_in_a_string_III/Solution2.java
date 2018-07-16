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

// 自己写reverse 自己来split
// 原来的空格保留
class Solution {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int last = 0;
        for (int i=0; i<= c.length ; i++){
            if( i== c.length || c[i]== ' ' ){
                rev(c, last, i-1);
                last = i+1;
            } 
        }
        return new String(c);
    }
    
    public void rev(char[] c, int i,int j){
        while (i<j){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i+=1;
            j-=1;
        }
    }
}