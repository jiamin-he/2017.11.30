/*
Author: Jiamin
Date: July 14, 2018
Problem: reordered power of 2
Difficulty: medium

Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true
*/
class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] sc = Integer.toString(N).toCharArray();
        char[] alpha = new char[10];
        for(int i = 0; i < sc.length; i++){
            alpha[sc[i]-'0']++;
        }
        return helper(alpha, 0, sc.length,sc.length);
    }
    public boolean powerOfTwo(int res) {
        while(res%2==0){
            res/=2;
        }
        return res==1?true:false;
    }
    public boolean helper(char[] alpha, int cur, int left, int ori) {
        if(left == 0) {
            return powerOfTwo(cur);
        }
        for(int i = 0; i < alpha.length; i++) {
            if(left == ori && i==0) continue;
            if(alpha[i]>0) {
                int temp = cur*10+i;
                alpha[i]--;
                if(helper(alpha, temp,left-1,ori)) {
                    return true;   
                }  
                alpha[i]++;
            }
        }
        return false;
    }
}