/*
Author: Jiamin
Date: July 14, 2018
Problem: reordered power of 2
Difficulty: medium

Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

 

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
 

Note:

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9
*/

// TLE
// dfs
// 复杂度太大！！是阶乘啊！！
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            if(!map.containsKey(A[i])) {
                map.put(A[i],0);
            } 
            map.put(A[i],map.get(A[i])+1);
        }
        int[] res = new int[A.length];
        int[] resVal = new int[]{Integer.MIN_VALUE};
        helper(map, new int[A.length], 0,resVal , B, res);
        return res;
    }
    
    public void helper(Map<Integer, Integer> map, int[] cur, int index, int[] resVal, int[] B, int[] res) {
        if(index == cur.length) {
            int count = 0;
            for(int i = 0; i< cur.length; i++){
                if(cur[i] > B[i]) {
                    count++;
                }
            }
            if(count > resVal[0]) {
                //res = cur;
                for(int i = 0; i< cur.length; i++){
                    res[i] = cur[i];
                }
                resVal[0] = count;
            }
            return;
        }
        for(Integer i : map.keySet()) {
            if(map.get(i) > 0) {
                map.put(i,map.get(i)-1);
                cur[index++] = i;
                helper(map, cur, index,resVal, B, res);
                map.put(i, map.get(i)+1);
                index--;
            }
        }
    }
    
}