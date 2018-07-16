/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 08, 2018
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

// 43ms 84%
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        if(nums.length < 1) return new int[0];
        stack.push(0);
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        
        for(int i = 1; i < nums.length*2; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%nums.length]) {
                res[stack.pop()] = nums[i%nums.length];
            }
            if(i<nums.length) {
                stack.push(i);
            }
            if(stack.isEmpty()) break;
        }
        
        
        return res;
    }
}