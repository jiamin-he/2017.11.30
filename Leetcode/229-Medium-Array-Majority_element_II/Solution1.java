/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 5, 2017
 Problem:    Majority Element II
 Difficulty: Easy
 Notes:

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

*/

import java.util.*;

class Solution1 {

    public List<Integer> findCandidate(int[] nums){
        int num1 = 0, num2 = 1;
        int count1 = 0, count2 = 0;
        for(int num: nums) {
            if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (num1 == num) {
                count1 ++;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else if (num2 == num) {
                count2 ++;
            } else {
                count1 --;
                count2 --;
                if (count1 == 0 && count2 > 0) {
                    num1 = num2;
                    count1 = count2;
                    num2 = 0;
                    count2 = 0;
                }
            }
        }
        if (count1 > 0) {
            count1 = 0;
            for(int num: nums) if (num1 == num) count1 ++;
        }
        if (count2 > 0) {
            count2 = 0;
            for(int num: nums) if (num2 == num) count2 ++;
        }
        List<Integer> results = new ArrayList<>();
        if (count1*3>nums.length) results.add(num1);
        if (count2*3>nums.length) results.add(num2);
        return results;
      }

    public static void main(String[] args) {
        
    }
}

