/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 21, 2017
 Problem:    Reverse Integer
 Difficulty: easy
 Notes:
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:


Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

// 35ms 97%
class Solution {
    public int reverse(int x) {
        int res = 0;
        boolean neg = false;
        if(x < 0) {
            neg = true;
            x *= -1;
        }
        while(x!=0) {
            res =res*10 + x%10;
            if(res%10 != x%10) return 0;
            x/=10;
        }
        return neg?(-1*res):res;
    }
}

// 带着负号也可以照常计算 取余 和 取模 但可能运算会慢一点
// 38ms
class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x!=0) {
            res =res*10 + x%10;
            if(res%10 != x%10) return 0;
            x/=10;
        }
        return res;
    }
}


// Sep 21st 2018 review

class Solution {
    public int reverse(int x) {
        int res = 0;
        while( x != 0) {
            res = res * 10 + x % 10;
            if(res % 10 != x % 10) return 0;
            x /= 10;
        }
        return res;
    }
}