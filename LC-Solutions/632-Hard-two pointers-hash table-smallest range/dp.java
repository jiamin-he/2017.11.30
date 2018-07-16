/*
Author: Jiamin
Date: Jan 08, 2017
Problem: smallest range
Difficulty: hard

You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Note:
The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.

*/

// 42ms 97%
class Solution {
    class Interval {
        int value;
        int list;
        Interval(int v, int l) {
            value = v;
            list = l;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        if(nums == null || nums.size() == 0) return new int[0];
        int size = nums.size();
        int[] indices = new int[size];
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2) {
               return i1.value - i2.value;
           } 
        });
        int right = 0;
        for(int i = 0; i < size; i++) {
            int temp = nums.get(i).get(0);
            if (temp > right) right = temp;
            pq.offer(new Interval(temp,i));
        }
        int left = pq.peek().value, leftL = left, rightR = right;
        while(true) {
            Interval prev = pq.poll();
            indices[prev.list]++;
            if(indices[prev.list] < nums.get(prev.list).size()) {
                int temp = nums.get(prev.list).get(indices[prev.list]);
                right = Math.max(right, temp);
                pq.offer(new Interval(temp, prev.list));
                left = pq.peek().value;
                if((right - left) < (rightR - leftL)) {
                    rightR = right;
                    leftL = left;
                }
            } else {
                break;
            }
        }
        return new int[] {leftL, rightR};
    }
}