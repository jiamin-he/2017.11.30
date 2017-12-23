/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 22, 2017
 Problem:    reverse string
 Difficulty: easy
 Notes:

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".



*/

class Solution {
    public String reverseString(String s) {
        char[] sc = s.toCharArray();
        for(int i = 0, j = sc.length -1; i <j ; i++, j--) {
            char temp = sc[i];
            sc[i] = sc[j];
            sc[j] = temp;
        }
        return new String(sc);
    }
}