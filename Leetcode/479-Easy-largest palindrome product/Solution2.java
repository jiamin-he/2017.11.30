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

// 510 ms  50%
public int largestPalindrome(int n) {
        // if input is 1 then max is 9 
        if(n == 1){
            return 9;
        }
        
        // if n = 3 then upperBound = 999 and lowerBound = 99
        int upperBound = (int) Math.pow(10, n) - 1, lowerBound = upperBound / 10;
        long maxNumber = (long) upperBound * (long) upperBound;
        
        // represents the first half of the maximum assumed palindrom.
        // e.g. if n = 3 then maxNumber = 999 x 999 = 998001 so firstHalf = 998
        int firstHalf = (int)(maxNumber / (long) Math.pow(10, n));
        
        boolean palindromFound = false;
        long palindrom = 0;
        
        while (!palindromFound) {
            // creates maximum assumed palindrom
            // e.g. if n = 3 first time the maximum assumed palindrom will be 998 899
            palindrom = createPalindrom(firstHalf);
            
            // here i and palindrom/i forms the two factor of assumed palindrom
            for (long i = upperBound; upperBound > lowerBound; i--) {
                // if n= 3 none of the factor of palindrom  can be more than 999 or less than square root of assumed palindrom 
                if (palindrom / i > maxNumber || i * i < palindrom) {
                    break;
                }
                
                // if two factors found, where both of them are n-digits,
                if (palindrom % i == 0) {
                    palindromFound = true;
                    break;
                }
            }

            firstHalf--;
        }

        return (int) (palindrom % 1337);
    }

    private long createPalindrom(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }



// 652 ms 27%
public class Solution {
    public int largestPalindrome(int n) {
        if(n == 1) return 9;
        int m = 1337;
        int mod = (int)Math.pow(10, n);
        int max = (int)Math.pow(10, n)-1;
        long pro = (long)max*(long)max;
        int right = (int)(pro%mod);
        int left = (int)(pro/mod);
        if(left == reverse(right,n)) return (int)(pro%m);
        if(left > right) {left--;}
        pro = (long)left*(long)mod+(long)reverse(left,n);
        while(left != mod/10){
            for(int i = max;i>pro/i;i--){
                if(pro%i == 0 ) {
                    return (int)(pro%m);
                }
            }
            left--;
            pro = (long)left*(long)mod+(long)reverse(left,n);
        }
        
        return (int)(pro%m);
    }
    
    private int reverse(int n, int dig){
        int x = n;
        int res = 0;
        int ten = (int)Math.pow(10,dig-1);
        while(x != 0 ){
            int d = x%10;
            res+=ten*d;
            ten/=10;
            x/=10;
        }
        return res;
    }
   
}


