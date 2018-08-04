/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 21, 2018
 Problem:    Valid Perfect Square
 Difficulty: Easy
 Notes:

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/

// 0 ms 100%
class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 0, end = num, pos = -1;
        while(start <= end) {
            int mid = start+(end-start)/2;
            long temp = (long)mid*mid;
            if(temp > num){
                end = mid-1;
            } else {
                pos = mid;
                start = mid+1;
            }
        }
        return pos*pos == num;
    }
}