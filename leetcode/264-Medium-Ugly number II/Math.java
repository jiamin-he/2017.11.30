/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 01, 2018
 Problem:    Ugly Number II
 Difficulty: Medium
 Notes:

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/

// 13ms 44%
// O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int[] ret = new int[n];
        ret[0] = 1;
        int[] base = new int[] {2,3,5};
        int[] mul = new int[3];
        
        for(int i = 1; i < n; i++){
            int curMin = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j < 3; j++){
                int temp = ret[mul[j]]*base[j];
                if(temp <= curMin) {
                    curMin = temp;
                    minIndex = j;
                }
            }
            mul[minIndex]++;
            if(i>0 && ret[i-1] != curMin) {
                ret[i] = curMin;
            } else {
                i--;
            }
        }
        return ret[n-1];
    }
}