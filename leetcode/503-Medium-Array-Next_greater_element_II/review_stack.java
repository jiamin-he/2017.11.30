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

// 34ms 93%
class Solution {
    class Number {
        int val;
        int index;
        
        Number(int v, int i){
            val = v;
            index = i;
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        Stack<Number> stack = new Stack<>();
        if(nums.length < 1) return new int[0];
        stack.push(new Number(nums[0],0));
        int[] res = new int[nums.length];
        
        for(int i = 1; i < nums.length; i++){
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                Number temp = stack.pop();
                res[temp.index] = nums[i];
            }
            stack.push(new Number(nums[i],i));
        }
        
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                Number temp = stack.pop();
                res[temp.index] = nums[i];
            }
            if(stack.size() == 1) break;
        }
        while(!stack.isEmpty()){
            Number temp = stack.pop();
            res[temp.index] = -1;
        }
        
        return res;
    }
}