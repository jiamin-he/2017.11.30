/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 07, 2017
 Problem:    Combination Sum
 Difficulty: Medium
 Notes:

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]


*/

// 注意 按套路这么如下写 会出现重复的combination！！！
// 那怎么办呢！！！
// 还是需要from！且每次从当前index开始继续dfs 不要index+1！！
// 下面那个是正确的！！！！
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), target,candidates);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int target, int[] candidates) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(res, list, target-candidates[i],candidates);
            list.remove(list.size() - 1);    
        }
    }
}


// the correct one!!!
// 23ms 47%
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(candidates); 
        // 先sort 效率会稍微高一些
        dfs(res, new ArrayList<Integer>(), target,0, candidates);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int target, int idx, int[] candidates) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        // for(int i = idx; i < candidates.length; i++) {
        for(int i = idx; i < candidates.length && target >= candidates[i]; i++) {
        // 在sorted 的基础上 改成这样 会快一点 20ms 65%
            list.add(candidates[i]);
            dfs(res, list, target-candidates[i], i, candidates);
            list.remove(list.size() - 1);    
        }
    }
}