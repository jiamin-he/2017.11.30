/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 29, 2017
 Problem:    excel sheet column number
 Difficulty: Easy
 Notes:
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 


*/

// 相当于26进制！！所以需要digit来控制每次进制要乘上的26；
// n+= (sc[i]-'A'+1) 这样是不行的！

class Solution {
    public int titleToNumber(String s) {
        int n = 0, digit = 1;
        char[] sc = s.toCharArray();
        for(int i = sc.length-1; i >= 0; i--) {
            n+= (sc[i]-'A'+1)*digit;
            digit*= 26;
        }
        return n;
    }
}