/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 30, 2018
 Problem:    Partition Array into Disjoint Intervals
 Difficulty: Medium
 Notes:
Given an array A, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

 

Example 1:

Input: [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
Example 2:

Input: [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
 

Note:

2 <= A.length <= 30000
0 <= A[i] <= 10^6
It is guaranteed there is at least one way to partition A as described.

 */

class Solution {
    public int partitionDisjoint(int[] A) {
        int len = A.length;
        int[] leftMax = new int[len], rightMin = new int[len];
        leftMax[0] = A[0]; // left included
        rightMin[len-1] = Integer.MAX_VALUE; // right not included
        for(int i = 1; i < len; i++) {
            if(A[i] > leftMax[i-1]) {
                leftMax[i] = A[i];
            } else {
                leftMax[i] = leftMax[i-1];
            }
        }
        for(int i = len - 2; i >= 0; i--) {
            if(A[i+1] < rightMin[i+1]) {
                rightMin[i] = A[i+1];
            } else {
                rightMin[i] = rightMin[i+1];
            }
        }
        int candidate = 0;
        while(candidate < len && leftMax[candidate] > rightMin[candidate]) {
            //System.out.println(candidate + " " + leftMax[candidate] + " " + rightMin[candidate]);
            candidate++;
            
        }
        return candidate + 1;
    }
}

// if you don't want to consider if left or right is included. 
// you can do like this below
class Solution {
    public int partitionDisjoint(int[] A) {
        int N = A.length;
        int[] maxleft = new int[N];
        int[] minright = new int[N];

        int m = A[0];
        for (int i = 0; i < N; ++i) {
            m = Math.max(m, A[i]);
            maxleft[i] = m;
        }

        m = A[N-1];
        for (int i = N-1; i >= 0; --i) {
            m = Math.min(m, A[i]);
            minright[i] = m;
        }

        for (int i = 1; i < N; ++i)
            if (maxleft[i-1] <= minright[i])
                return i;

        throw null;
    }
}