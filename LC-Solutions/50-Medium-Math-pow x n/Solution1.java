/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 21st, 2017
 Problem:    Pow(x, n)
 Difficulty: medium
 Notes:
Implement pow(x, n).


Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
*/

// 注意考虑负数！！
// 这么写 TLE 了！！！ 当n巨大无比时...
class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        boolean flag = false;
        if(n<0) {
            flag = true;
            n*= -1;
        }
        while(n-- > 0) {
            res = res*x;
        }
        if(flag) return 1/res;
        return res;
    }
}

// 这样写 过不去 n== Integer.MIN_VALUE 的那个test case
// 2.00000
// -2147483648
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}

// 这样就对啦！
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}