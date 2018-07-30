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

// 134 ms 80%
// space: O(N)
// time: initialize: O(1), pick: O(n)
/*
水塘抽样
https://www.cnblogs.com/youxin/p/3348225.html
其实就是：在不知道文件总行数n的情况下，怎样用相等的概率随机抽取k个样本
*/
class Solution {
    int[] nums = null;
    Random r = new Random();
    
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0;
        int rst = -1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count++;
                
                int random = r.nextInt(count);
                if(random == 0) {
                    rst = i;
                }
            }
        }
        
        return rst;
    }
}


// same 

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

class Solution {
    private Random random;
    private int[] nums;
    
    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int candidate = -1, count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {                // 选中当前
                if (random.nextInt(count++) == 0) { // random.nextInt(++count) == 0 的概率为 1/count
                    candidate = i;                  // 即以 1/count 的概率选择将当前的 i 替换为 candidate
                }
            }
        }
        return candidate;
    }
}