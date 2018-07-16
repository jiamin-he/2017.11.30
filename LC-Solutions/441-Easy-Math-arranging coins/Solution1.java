/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 30, 2017
 Problem:    arranging coins
 Difficulty: Easy
 Notes:
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
*/

// TLE !!!
class Solution {
    public int arrangeCoins(int n) {
        if(n < 0) return -1;
        int i = 1;
        while((i+1)*i/2 <= n){
            i++;
        }
        return i-1;
    }
}

// Atten! solve the quadratic equation.
// 8.0 is very important here !
// use 8 will get a different answer and it's wrong.
class Solution {
    public int arrangeCoins(int n) {
        if(n < 0) return -1;
        // System.out.println(Math.sqrt(1+ 8*n)-1);
        // System.out.println(Math.sqrt(1+ 8.0*n)-1);
        return (int)((Math.sqrt(1+ 8.0*n)-1)/2);
    }
}
