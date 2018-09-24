/*
Author: Jiamin
Date: Sep 21, 2018
Problem:  Smallest Range I
Difficulty: easy

Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.

 

Example 1:

Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
Example 2:

Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]
Example 3:

Input: A = [1,3,6], K = 3
Output: 0
Explanation: B = [3,3,3] or B = [4,4,4]
 

Note:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000
 
*/
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int curMin = Integer.MAX_VALUE, curMax = 0;
        for(int i = 0; i < A.length; i++) {
            curMax = Math.max(curMax, A[i]);
            curMin = Math.min(curMin, A[i]);
        }
        int diff = curMax - curMin;
        return diff <= 2 * K ? 0 : diff - 2 * K;
    }
}