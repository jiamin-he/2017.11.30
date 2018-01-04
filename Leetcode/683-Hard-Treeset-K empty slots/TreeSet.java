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

// treeset 
// 117ms 38% 
// O NlogN
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> bloomPos = new TreeSet<>();
        int day = 0;
        for(int flower: flowers) {
            day++;
            bloomPos.add(flower);
            Integer leftBloom = bloomPos.lower(flower);
            Integer rightBloom = bloomPos.higher(flower);
            if( (leftBloom != null && flower - leftBloom -1 == k) || (rightBloom != null && rightBloom - flower - 1 == k))
                return day;
        }
        return -1;
    }
}