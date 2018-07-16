/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 08, 2018
 Problem:    next greater element iii
 Difficulty: medium
 Notes:

Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21
 

Example 2:

Input: 21
Output: -1

*/

// 2ms 99%
// suggestions for next review: re write swap (int[], int, int) (move the checking which one to be swapped part out of the method.) -- see the solution to understand clearly who to be swapped. and change the reorder to reverse (coz there is no need to sort it.-- already sorted.)
class Solution {
    public int nextGreaterElement(int n) {
        int[] digits = new int[Integer.toString(n).toCharArray().length];
        int on = n;
        for(int i=digits.length-1; i>=0; i--){
            digits[i] = n%10;
            n/=10;
        }
        int pos = -1;
        for(int i = digits.length-1; i>0; i--){
            if(digits[i-1]<digits[i]){
                pos= i-1;
                break;
            }
        }
        if(pos == -1) return -1;
        swap(digits, pos);
        reorder(digits,pos+1);
        long res = 0;
        for(int i = 0; i<digits.length; i++){
            res = res*10+digits[i];
        }
        return (res==on || res>Integer.MAX_VALUE)? -1:(int)res;
    }
    public void swap(int[] digits, int p){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i =p+1; i < digits.length; i++){
            if(digits[i]>digits[p] && digits[i] < min){
                min = digits[i];
                index = i;
            }
        }
        int temp = digits[p];
        digits[p] = digits[index];
        digits[index] = temp;
    }
    public void reorder(int[] digits, int p){
        int[] copy = Arrays.copyOfRange(digits, p, digits.length);
        Arrays.sort(copy);
        for(int i = p; i < digits.length; i++){
            digits[i] = copy[i-p];
        }
    }
}