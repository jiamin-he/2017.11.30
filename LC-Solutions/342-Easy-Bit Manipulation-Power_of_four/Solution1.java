/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 22, 2017
 Problem:    Power of Four
 Difficulty: easy
 Notes:

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

*/

import java.util.*;

class Solution1 {

    public boolean isPowerOfFour(int n) {
        return ( n>0 && (n & (n-1)) == 0 && ((n & 0x55555555) == n));
    }

    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        while(n % 4 == 0) n = n / 4;
        return (n==1);
    }

    public boolean isPowerOfFour(int num) {
        return (Math.log10(num)/Math.log10(4) % 1 == 0);
    }

    
}

    public static void main(String[] args) {
       
    }
}
