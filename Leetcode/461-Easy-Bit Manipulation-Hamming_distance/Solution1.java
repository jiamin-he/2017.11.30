/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 22, 2017
 Problem:    Hamming Distance
 Difficulty: easy
 Notes:

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 23^1.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

*/

import java.util.*;

class Solution1 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
        // bit count --> returns the number of one-bits
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }

     public int hammingDistance(int x, int y) {
        if (x == y) return 0;

        int diff = x ^ y;
        int res = 0;
        if ((diff & 1) == 1) res++;

        while ((diff>>1) != 0) {
            if (((diff>>1) & 1) == 1) {
                res++;
            }
            diff = diff >> 1;
        }

        return res;
    }

    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (x % 2 != y % 2) {count++;}
            x = x / 2;
            y = y / 2;    
        }
        return count;
    }

    public int hammingDistance(int x, int y) {
        int b= (x ^ y);
        int c=0;
        while(b>0) {
            c+=1;
            b&=(b-1);
        }
        return c;
    }

    public static void main(String[] args) {
       
    }
}
