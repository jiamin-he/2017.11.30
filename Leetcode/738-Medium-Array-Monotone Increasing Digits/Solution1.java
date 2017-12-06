/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 02, 2017
 Problem:    Monotone Increasing Digits
 Difficulty: Medium
 Notes:

Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9].

*/

class Solution {
    public int monotoneIncreasingDigits(int N) {
        int num = N;
        ArrayList<Integer> digits = new ArrayList<>();
        while(N > 0){
            digits.add(0,N % 10);
            N /= 10;
        }
        int change = 0;
        int i = 1;
        for(; i < digits.size() ; i++){
            if (digits.get(i-1) > digits.get(i)){
                change = i;
                while(i >= 2 && digits.get(i-1) == digits.get(i-2)){
                    i--;
                }
                break;
            }
        }
        if(change <= 0){
            return num;
        }
        int res = 0;
        change = Math.min(change,i)-1;
        for(i = 0; i < digits.size(); i++){
            if(i < change){
                res = res * 10 + digits.get(i);
            } else if (i > change){
                res = res * 10 + 9;
            } else{
                res = res * 10 + digits.get(i) -1;
            }
        }
        return res;
    }
}
