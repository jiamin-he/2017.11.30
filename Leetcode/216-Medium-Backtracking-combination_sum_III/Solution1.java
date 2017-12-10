/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 07, 2017
 Problem:    Combination Sum III
 Difficulty: Medium
 Notes:

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), n, 1, 10-k, k );
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int target, int start, int end, int k) {
        if(target < 0) return;
        if(target == 0 && k == 0 ) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i < 10 && target >= i; i++) {
            list.add(i);
            dfs(res, list, target-i, i+1, end++, k-1);
            list.remove(list.size() - 1);    
        }
    }
}