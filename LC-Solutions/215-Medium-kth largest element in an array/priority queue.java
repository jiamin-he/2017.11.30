/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 29, 2017
 Problem:    Kth Largest Element in an Array
 Difficulty: Medium
 Notes:

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/


// O(nlogk)

// 9ms 67%
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);

        for(int el : nums) {
            largeK.add(el);
            if (largeK.size() > k) {
                largeK.poll();
            }
        }

        return largeK.poll();
    }
}

// 9ms 67%
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(k);
        for(int i = 0; i < nums.length; i++) {
            if(pq.size() >= k) {
                if(nums[i] > pq.peek()) {
                    pq.poll(); 
                    pq.offer(nums[i]);
                } 
            } else {
                pq.offer(nums[i]);    
            }
            
        }
        return pq.peek();
    }
}