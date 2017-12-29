/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 24, 2017
 Problem:    largest palindrome product
 Difficulty: Easy
 Notes:
Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.

Example:

Input: 2

Output: 987

Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

Note:

The range of n is [1,8].


*/

// 463 ms 77%
public class Solution {
    public int largestPalindrome(int n) {
        if (n==1) return 9;
        int max=(int)Math.pow(10, n)-1;
        for (int v=max-1;v>max/10;v--) {
            long u=Long.valueOf(v+new StringBuilder().append(v).reverse().toString());
            for (long x=max;x*x>=u;x--)
                if (u%x==0)
                    return (int)(u%1337);
        }
        return 0;
    }
}


// same idea as above
// but change the making palindrome part (stringbuilder then reverse then long) into 
// number making part, faster
// also use double ended to check if it is factor * factor, faster

// 69ms 96% 
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) 
            return 9;
        long max = (long)Math.pow(10, n)-1;
        long min = max/10+1;
        long t = 0;
        for (long num = max - 1; num >= min; num--) {
            t = makePalindrome(num);
            if (isFactorable(t, max, min)) {
                return (int)(t % 1337);
            }
        }
        return -1;
    }

    private long makePalindrome(long num) {
        long res = num;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
    
    public boolean isFactorable(long num, long max, long min) {
        long mid = (long)Math.sqrt(num);
        if (mid > max || mid < min) 
            return false;
        long low = mid, high = mid, t = low * high;
        while (t != num) {
            if (t < num) {
                if (++high > max) 
                    return false;
            } else {
                if (--low < min) 
                    return false;
            }
            t = low * high;
        }
        return true;
    }
    
}