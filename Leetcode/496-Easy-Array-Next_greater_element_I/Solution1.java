/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 08, 2017
 Problem:    Next Greater Element I
 Difficulty: Easy
 Notes:

You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.

*/

import java.util.*;

class Solution1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        
        Stack<Integer> s = new Stack<>();
        int element = 0, next = 0;
        Map<Integer,Integer> map = new HashMap<>();
        if(nums2.length == 0) return nums2;
        s.push(nums2[0]);
        for (int i = 1; i < nums2.length ; i++) {
            next = nums2[i];
            if (!s.isEmpty()) {
                element = s.pop();
                while (element < next) {
                    map.put(element, next);
                    if(s.isEmpty()) break;
                    element = s.pop();    
                }
                if(element > next) s.push(element);
            }
            s.push(next);
        }
        while(!s.isEmpty()){
            element = s.pop();
            map.put(element,-1);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length ; i++) {
            if (map.containsKey(nums1[i])) result[i] = map.get(nums1[i]);
            else result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        
        long start = System.currentTimeMillis(); // 记录起始时间

        
        Solution1 s1 = new Solution1();
        System.out.println(s1.islandPerimeter1(grid));

        long end = System.currentTimeMillis();       // 记录结束时间
        System.out.println("time: "+(end-start)+"ms");              // 相减得出运行时间

    }
}
