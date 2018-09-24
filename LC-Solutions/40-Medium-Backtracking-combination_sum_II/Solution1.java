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
		// 这样的条件更节省时间一点点
        for(int i = idx; i < candidates.length && target >= candidates[i]; i++) {
            if( i > idx && candidates[i] == candidates[i-1]) continue;
            // i > idx, 证明它不是起头的那个 前面已经被算过了 他不要被算了！！！！
            list.add(candidates[i]);
            dfs(res, list, target-candidates[i], i+1, candidates);
            list.remove(list.size() - 1);    
        }
    }
}

// Jul 29 2018 review
// 15ms 35%
// C(n, n) + C(n, n - 1) + C(n, n - 2) + C(n, n - 3) + .... + C(n, 1) ~= n^n
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,target,res,candidates,new ArrayList<Integer>(),0);
        return res;
    }
    public void helper(int sum, int target, List<List<Integer>> res, int[] candidates, List<Integer> cur, int i){
        if(sum == target){
			// 记得一定要new 一个arraylist！！不能直接放进去，否则最后都会被remove掉然后都变成空！！！
            res.add(new ArrayList<>(cur));
        } else if (sum < target) {
			
            for(int j = i; j < candidates.length; j++) {
                if(j > i && candidates[j] == candidates[j-1]) continue;
                cur.add(candidates[j]);
                helper(sum+candidates[j], target, res, candidates, cur, j+1);
				
				// 直接放int 的话 它会认为是指index！！！
                cur.remove((Integer)candidates[j]);
            }
        }
    }
}


// Sep 21st 2018 review
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, res, new ArrayList<>());
        return res;
    }
    
    public void dfs(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) {
                break;
            } else {
                if(i != start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                cur.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}