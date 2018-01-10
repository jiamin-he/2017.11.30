/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 05, 2017
 Problem:    add digits
 Difficulty: Easy
 Notes:

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?


*/

// 3ms 7%
class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int sum = 0;
        while(num > 0) {
            sum += num%10;
            num/=10;
        }
        return addDigits(sum);
    }
}

// 2ms
class Solution {
    public int addDigits(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
    }
}

// 1ms 
class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}