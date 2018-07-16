/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 02, 2017
 Problem:    k empty slots
 Difficulty: hard
 Notes:

There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.
Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1
Note:
The given array will be in the range [1, 20000].

*/

// sliding window
// 23ms 63% 
// O N
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] posDate = new int[flowers.length];
        for(int i = 0; i < flowers.length; i++){
            posDate[flowers[i] - 1] = i + 1; 
        }
        int left = 0, right = left + k + 1, res = Integer.MAX_VALUE;
        for(int i = 0; right < posDate.length; i++) {
            if ((posDate[i] < posDate[left]) || (posDate[i] <= posDate[right])) {
                if(i == right) {
                    res = Math.min(res, Math.max(posDate[left], posDate[right]));
                }
                left = i;
                right = left + k + 1;
            }
        }
        return res==Integer.MAX_VALUE? -1: res;
    }
}