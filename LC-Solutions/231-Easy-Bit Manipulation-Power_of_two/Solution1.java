/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 22, 2017
 Problem:    Power of Two
 Difficulty: easy
 Notes:

Given an integer, write a function to determine if it is a power of two.


*/

import java.util.*;

class Solution1 {

    public boolean isPowerOfTwo(int n) {
        return (Integer.bitCount(n) == 1 && n > 0);
    }

    public boolean isPowerOfTwo(int n) {
        return (n> 0 && (n & (n-1)) == 0 );
    }

    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        while(n % 2 == 0) {
            n = n / 2;
        }
        if(n == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
       
    }
}
