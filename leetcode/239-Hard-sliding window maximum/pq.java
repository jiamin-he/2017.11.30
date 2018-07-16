/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 05, 2018
 Problem:    Sliding Window Maximum
 Difficulty: Hard
 Notes:

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/


// 51 ms 25%
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums.length < 1 ) return new int[0];
        int[] ret = new int[nums.length - k +1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare (Integer i1, Integer i2) {
                return i2-i1;
            }
        });
        
        for( int i =0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for(int i = 0; i < ret.length; i++){
            ret[i] = pq.peek();
            pq.remove(nums[i]);
            if(i+k < nums.length)
                pq.offer(nums[i+k]);
        }
        return ret;
    }
}