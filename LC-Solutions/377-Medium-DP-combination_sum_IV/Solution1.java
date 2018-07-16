/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 07, 2017
 Problem:    Combination Sum IV
 Difficulty: Medium
 Notes:

Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

*/

// time limit exceed!!! 转用dp咯～！
// and这道题不用返回具体组合是什么 只要count就行了 所以不用写的这么麻烦！
class Solution {
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), target, nums);
        return res.size();
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int target, int[] nums) {
        if(target < 0) return;
        if(target == 0 ) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(res, list, target-nums[i], nums);
            list.remove(list.size() - 1);    
        }
    }
}

// 简化一些
// 仍然tle
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[1];
        dfs(new ArrayList<Integer>(), target, nums, res );
        return res[0];
    }
    public void dfs(List<Integer> list, int target, int[] nums, int[] res) {
        if(target < 0) return;
        if(target == 0 ) {
            res[0]++;
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(list, target-nums[i], nums,res);
            list.remove(list.size() - 1);    
        }
    }
}

// 继续把 dfs这个 简化
// 仍然tle
// 为什么可以这么简化？ 走dfs 是为了记录每一次的路径
// 但现在无需返回路径 所以可以不用专门写dfs 而直接在自己原函数那里递归
class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(target == 0 ) {
            return 1;
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target >= nums[i]) {
                count += combinationSum4(nums, target-nums[i]);
            }
        }
        return count;
    }
}

// 从上面这个思路 接下来要去改成dp 就很好改了（之前的题不能改dp 是因为要求返回路径）
// 现在只需返回值 所以dp就很好用了
// 要怎么改成dp呢？ 就是把每一个combinationSum4的值存下来 下一次要用到它时如果有它 就可以直接用了
// 1ms 83%
// 这是top-down的写法 那怎么用dp方程写呢？
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        helper(nums,target,dp);
        return dp[target];
    }
    public int helper(int[] nums, int target, int[] dp) {
        if(dp[target] >= 0) return dp[target];
        int count = 0;
        if(target == 0 ) {
            return 1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(target >= nums[i]) {
                count += helper(nums, target-nums[i],dp);
            }
        }
        dp[target] = count;
        return count;
    }
}

// bottom-up 
// 这个比上面那个慢了
// 5ms 31%
// 为什么呢？因为上面是 需要它 所以去算它
// 但这里是一直遍历在算 填满dp数组 遍历过程中有时会做无用功！
// 上面在backtrack的过程中prune 提高效率
// 相当于楼上是给backtrack加了memorization
// 那如果用别的做memorization呢？
// 看这个方法的下一个方法
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i >= nums[j]) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}

// 用hashmap来做memorization
// 但其实没有必要啦， 因为这里的array直接index当作了hashmap的key来存对应的value值
// so they are the same！
// 而且用hashmap好慢的～～
// 7ms 11%
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length ==0 || target < 0 ) return 0;
        if ( target ==0 ) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int num: nums){
            count += combinationSum4(nums, target-num);
        }
        map.put(target, count);
        return count;
    }
}
// 不想用全局变量的话， 这么改也行
// 11ms 3%
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(nums,target,map);
        return map.get(target);
    }
    public int helper(int[] nums, int target, Map<Integer,Integer> map) {
        if(map.containsKey(target)) return map.get(target);
        int count = 0;
        if(target == 0 ) {
            return 1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(target >= nums[i]) {
                count += helper(nums, target-nums[i],map);
            }
        }
        map.put(target, count);
        return count;
    }
}