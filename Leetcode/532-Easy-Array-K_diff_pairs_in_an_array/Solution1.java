/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 07, 2017
 Problem:    K-diff pairs in an array
 Difficulty: Easy
 Notes:

Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].

*/

import java.util.*;

class Solution1 {

    public int findPairs(int[] nums, int k){
    	if(k<0) return 0;
        int count = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        if(k>0){
            for(int num: nums) {
                set1.add(num);
                set2.add(num+k);
                }
            set1.retainAll(set2); 
            count = set1.size();
            }
        else{
            for(int num: nums) {
                if(!set1.contains(num)) set1.add(num);
                else {
                    if(!set2.contains(num)) {
                        set2.add(num);
                        count++;
                    }
                } 
                }
        }
        return count;
    }

    public static void main(String[] args) {
        
        long start = System.currentTimeMillis(); // 记录起始时间

        
        Solution1 s1 = new Solution1();
        System.out.println(s1.islandPerimeter1(grid));

        long end = System.currentTimeMillis();       // 记录结束时间
        System.out.println("time: "+(end-start)+"ms");              // 相减得出运行时间

    }
}
