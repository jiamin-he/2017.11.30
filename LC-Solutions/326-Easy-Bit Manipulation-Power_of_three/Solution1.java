/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 22, 2017
 Problem:    Power of Three
 Difficulty: easy
 Notes:

Given an integer, write a function to determine if it is a power of three.


*/

import java.util.*;

class Solution1 {

    public boolean isPowerOfThree(int n) {
        return ();
    }

    public boolean isPowerOfThree(int n) {
        return ( n>0 && (n==1 || (n%3 == 0 && isPowerOfThree(n/3))));
    }

    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        while(n % 3 == 0) {
            n = n / 3;
        }
        return (n==1);
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree(int num) {
        int k = (int)(Math.log(Integer.MAX_VALUE)/Math.log(3));
        return num > 0 && (int)(Math.pow(4,k)) % num == 0;
    }
}

    public static void main(String[] args) {
       
    }
}
