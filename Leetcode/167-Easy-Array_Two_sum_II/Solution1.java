/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 6, 2017
 Problem:    Two Sum II -Input Array Sorted
 Difficulty: Easy
 Notes:

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/

class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        
        int start = 0, end = numbers.length-1;
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if (sum < target) start++;
            else if (sum > target) end--;
            else break;
        }

        int[] result = new int[2];
        result[0] = start+1;
        result[1] = end+1;
        return result;

    }
}
