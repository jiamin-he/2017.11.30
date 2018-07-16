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


class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        boolean[] flag = new boolean[A.length];
        Arrays.sort(A);
        int[] res = new int[A.length];
        int n = 0;
        for(int i:B){
            int index = search(A,i);
            res[n++] = get(A,flag,index,i);
        }
        return res;
    }
    private int get(int[] nums,boolean[] flag,int index,int target){
        if(nums[index]>target&&flag[index] == false) {flag[index] = true; return nums[index];}
        // to find a  number bigger than A[index] in A which no be used 
        for(int i =index+1;i<nums.length;i++)
            if(flag[i] == false) {flag[i] = true; return nums[i];}
        // if above operation can't find a number, then return the minmum number
        for(int i =0;i<nums.length;i++) 
            if(flag[i] == false) {flag[i] = true; return nums[i];}
        return Integer.MIN_VALUE;
    }
    /*using binary search to find num just a litter bigger than target*/
    public int search(int[] nums, int target){
        if(target<nums[0]) return 0;
        int lo = 0, hi = nums.length-1;
        int mid;
        while(lo<hi){
            mid = lo + (hi-lo)/2;
            if(nums[mid] >target) hi = mid;
            else lo =mid+1;
        }
        return hi;
    }
}