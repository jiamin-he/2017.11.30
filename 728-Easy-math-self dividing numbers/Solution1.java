/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 24, 2017
 Problem:    self dividing numbers
 Difficulty: Easy
 Notes:

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.
*/

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        while (left <= right){
            if(digits(left)) res.add(left);
            left++;
        }
        return res;
    }
    
    public boolean digits (int num){
        int n = num;
        while(n > 0){
            int digit = n % 10;
            if (digit == 0 || num % digit != 0 )
                return false;
            n = n/10;
        }
        return true;
    }
}
