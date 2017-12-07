/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    excel sheet column title
 Difficulty: Easy
 Notes:
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

*/

class Solution {
    public String convertToTitle(int n) {
        String s = "";
        if( n <= 0) return s;
        while(n > 0) {
            s = (char) ((n-1)%26 + 65) + s; 
            n = (n-1)/26;
        }
        return s;
    }
}

// you can write it in one-line
return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));