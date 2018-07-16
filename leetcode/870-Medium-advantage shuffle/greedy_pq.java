/*
Author: Jiamin
Date: July 14, 2018
Problem: reordered power of 2
Difficulty: medium

Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

 

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
 

Note:

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9
*/


// O(nlogn)
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                return i2[0]-i1[0];
            }
        });
        for(int i = 0; i < B.length; i++) {
            pq.offer(new int[]{B[i],i});
        }
        int right = A.length-1;
        int left = 0;
        int[] res = new int[A.length];
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(A[right] > cur[0]) {
                res[cur[1]] = A[right];
                right--;
            } else {
                res[cur[1]] = A[left];
                left++;
            }
        }
        return res;
    }
}