/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 5, 2017
 Problem:    Majority Element
 Difficulty: Easy
 Notes:

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

import java.util.*;

class Solution1 {
    
    public int majorityElement(int[] nums){
    	int[] bit = new int[32];
    	for (int num: nums)
        	for (int i=0; i<32; i++) 
            	if ((num>>(31-i) & 1) == 1) bit[i]++;
    	int result=0;
    	for (int i=0; i<32; i++) {
        	bit[i]=bit[i]>nums.length/2?1:0;
        	ret += bit[i]*(1<<(31-i));
    	}
    	return result;
    }

    public static void main(String[] args) {
        
    }
}
