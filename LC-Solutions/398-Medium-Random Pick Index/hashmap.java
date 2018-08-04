/*
Author: Jiamin
Date: Jul 29, 2018
Problem: Random Pick Index
Difficulty: medium

Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
*/

// 202 ms 3%
// space: O(N)
// time: initialize: O(N), pick: O(1)
class Solution {
    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for( int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> set = new ArrayList<>();
                set.add(i);
                map.put(nums[i], set);
            }
        }
    }
    
    public int pick(int target) {
        int i = (int)(Math.random()*map.get(target).size());
        System.out.println(i);
        return map.get(target).get(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */