/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 08, 2017
 Problem:    Next Greater Element II
 Difficulty: Medium
 Notes:

Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.

*/

import java.util.*;

class Solution1 {

    public int[] nextGreaterElement(int[] nums){
        
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        
        long start = System.currentTimeMillis(); // 记录起始时间

        
        Solution1 s1 = new Solution1();
        System.out.println(s1.islandPerimeter1(grid));

        long end = System.currentTimeMillis();       // 记录结束时间
        System.out.println("time: "+(end-start)+"ms");              // 相减得出运行时间

    }
}
