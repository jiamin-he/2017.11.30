/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 09, 2017
 Problem:    Sqrt(x)
 Difficulty: easy
 Notes:
Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
*/

//26ms 50%
class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}

// 22ms 93%
class Solution {
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        long low = 1;
        long high = x;
        while(low+1<high){
            long mid = low + (high - low)/2;
            if(mid * mid == x){
                return (int) mid;
            }else if( mid * mid < x){
                low = mid;
            }else {
                high = mid;
            }
        }
        if(high * high < x){
            return (int) high;
        }else{
            return (int) low;
        }      
    }
}