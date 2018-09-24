/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 17th, 2018
 Problem:    Shuffle an array
 Difficulty: Medium
 Notes:

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

*/

// 232 ms 25%
class Solution {

    int[] numbers;
    
    
    public Solution(int[] nums) {
        numbers = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] res = numbers;
        return res;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[numbers.length];
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int num: numbers) {
            numberList.add(num);
        }
        helper(res, 0, numberList);
        return res;
    }
    
    public void helper(int[] cur, int index, ArrayList<Integer> numberList) {
        if(index >= numbers.length) return;
        int randomNum = (int)(Math.random()*numberList.size());
        cur[index] = numberList.get(randomNum);
        numberList.remove((int)randomNum);
        helper(cur, index+1, numberList);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */