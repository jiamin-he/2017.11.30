/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 07, 2017
 Problem:    combinations
 Difficulty: Medium
 Notes:

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

// 89ms 7%
// 很好理解！
// 但要注意到 这个方法 出现了多次重复计算值，对每取一个值之后进行递归都重复计算了后面的值
// 所以跑得很慢！
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n == k || k == 0) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 1; i <= k; i++) {
                temp.add(i);
            }
            //C(n,0) is an empty set, and C(n,n) is simply universal set {1,2,3,...,n}.
            return new ArrayList<>(Arrays.asList(temp));
            // 要先Arrays.asList 是因为 将temp 装成了一个list 也就符合了题目要求的返回值 list的list
        }
        List<List<Integer>> res = combine(n-1,k-1);
        res.forEach(e -> e.add(0,n));
        res.addAll(combine(n-1,k));
        return res;
    }
}


// 4ms 95%
// dfs
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), k, 1, n-k+1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int kLeft, int from, int to) {
        if (kLeft == 0) { ans.add(new ArrayList<Integer>(list)); return; }
        //Because comb will be modified later.(Remove the last one) If you add the current instance of comb into final result, the result could be wrong.
        for (int i=from; i<=to; ++i) {
            list.add(i);
            dfs(ans, list, kLeft-1, i+1, to+1);
            list.remove(list.size()-1);
        }
    }
}

//俺自己写了一次 same as above
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 1, n-k+1, k);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int start, int end, int k) {
        if(k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i <= end; i++) {
            list.add(i);
            dfs(res, list, i+1,end+1,k-1);
            list.remove(list.size() - 1);    
        }
    }
}

// 这里的 c + k > n + 1 作用同上法 
// 为了减少dfs的无用次数
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, current, 1, n, k);
        return result;
    }
    
    void dfs(List<List<Integer>> result, List<Integer> current, int c, int n, int k) {
        if (c + k > n + 1) {
            return;
        }
        if (k == 0) {
            List<Integer> tmpList = new ArrayList<>(current);
            result.add(tmpList);
            return;
        }
        current.add(c);
        dfs(result, current, c + 1, n, k - 1);
        current.remove(current.size() - 1);
        dfs(result, current, c + 1, n, k);
    }
}

// 这一个dfs就很慢！
// 63ms 18%
// 因为多跑了很多无用功
// 后面很多重复进入但跑不出来的结果
// eg 1234 取2个的话 4 开头的就不用跑了
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if (n <=0 || k < 0) { return res;}
        dfs(n, k, 1, item, res);
        return res;
    }
    
    public void dfs(int n, int k, int start, List<Integer> item, List<List<Integer>> res) {
    	if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
             dfs(n, k, i+1, item, res);
            item.remove(item.size()-1);
        }
    }
}