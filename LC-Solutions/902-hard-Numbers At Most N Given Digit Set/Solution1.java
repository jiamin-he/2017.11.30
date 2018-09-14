/*
Author: Jiamin
Date: Sep 8, 2018
Problem:  Numbers At Most N Given Digit Set
Difficulty: hard

We have a sorted set of digits D, a non-empty subset of {'1','2','3','4','5','6','7','8','9'}.  (Note that '0' is not included.)

Now, we write numbers using these digits, using each digit as many times as we want.  For example, if D = {'1','3','5'}, we may write numbers such as '13', '551', '1351315'.

Return the number of positive integers that can be written (using the digits of D) that are less than or equal to N.

 

Example 1:

Input: D = ["1","3","5","7"], N = 100
Output: 20
Explanation: 
The 20 numbers that can be written are:
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
Example 2:

Input: D = ["1","4","9"], N = 1000000000
Output: 29523
Explanation: 
We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
In total, this is 29523 integers that can be written using the digits of D.
 

Note:

D is a subset of digits '1'-'9' in sorted order.
1 <= N <= 10^9
 
*/
//TLE
class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int[] ds = new int[D.length];
        for(int i = 0; i < D.length; i++) {
            ds[i] = D[i].charAt(0) - '0';
        }
        int[] res = new int[2];
        helper(ds, res, N);
        return res[0];
    }
    
    public void helper(int[] ds, int[] res, int N) {
        for(int i = 0; i < ds.length; i++) {
            int temp = res[1];
            res[1] = temp*10 + ds[i];
            if(res[1] <= N) {
                res[0]++;
                helper(ds, res, N);
            }
            res[1] = temp;
        }
    }
}


// TLE
class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int[] ds = new int[D.length];
        int len = ds.length;
        for(int i = 0; i < D.length; i++) {
            ds[i] = D[i].charAt(0) - '0';
        }
        Arrays.sort(ds);
        long[] res = new long[4];
        res[3] = 1;
        int digit = Integer.toString(N).length();
        int digitCopy = digit;
        while(--digit > 0) {
            res[3] *= len;
            res[0] += res[3];   
        }
        helper(ds, res, N, digitCopy);
        return (int)res[0];
    }
    
    public void helper(int[] ds, long[] res, int N, int digit) {
        if(res[2] == digit) {
            if(res[1] <= N) {
                res[0]++;
            }
            return;
        }
        for(int i = 0; i < ds.length; i++) {
            long temp = res[1];
            res[1] = temp*10 + ds[i];
            if(res[1] > N) {
                res[1] = temp;
                break;
            }
            res[2]++;
            helper(ds, res, N, digit);
            res[1] = temp;
            res[2]--;
        }
    }
}