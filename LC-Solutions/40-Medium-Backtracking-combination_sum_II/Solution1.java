/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 07, 2017
 Problem:    Combination Sum II
 Difficulty: Medium
 Notes:

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); 
        dfs(res, new ArrayList<Integer>(), target,0, candidates);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int target, int idx, int[] candidates) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = idx; i < candidates.length && target >= candidates[i]; i++) {
            if( i > idx && candidates[i] == candidates[i-1]) continue;
            // i > idx, 证明它不是起头的那个 前面已经被算过了 他不要被算了！！！！
            list.add(candidates[i]);
            dfs(res, list, target-candidates[i], i+1, candidates);
            list.remove(list.size() - 1);    
        }
    }
}