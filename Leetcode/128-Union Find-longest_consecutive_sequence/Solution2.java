/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    Longest Consecutive Sequence
 Difficulty: Hard
 Notes:
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

*/

// 18 ms 15%
class Solution {
    public int longestConsecutive(int[] num) {
    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : num) {
        if (!map.containsKey(n)) {
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            int sum = left + right + 1;
            map.put(n, sum);
            res = Math.max(res, sum);
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        else {
            continue;
        }
    }
    return res;
}
}
