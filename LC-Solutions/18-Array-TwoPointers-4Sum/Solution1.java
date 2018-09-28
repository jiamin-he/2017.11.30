/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 4, 2018
 Problem:    4sum
 Difficulty: Medium
 Notes:

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

*/

// 用跟 3sum一摸一样的思路
// 但是要记得把target复原啊！！！
// O(N^3)
// 34ms 74%
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for ( int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i] != nums[i-1]) {
                for(int j = i+1; j < nums.length; j++) {
                    if( j==i+1 || nums[j] != nums[j-1]) {
                        
                        int left = j+1, right = nums.length-1; 
                        target -= (nums[i]+nums[j]);
                        while(left < right) {
                            int temp = nums[left] + nums[right];
                            if(temp < target) {
                                left++;
                            } else if (temp > target) {
                                right--;
                            } else {
                                res.add(Arrays.asList(nums[i],nums[j], nums[left], nums[right]));
                                int l = nums[left], r = nums[right];
                                while(left < right && nums[++left] == l);
                                while(right > left && nums[--right] == r);
                            }
                        }
                        target += (nums[i]+nums[j]);
                    }
                }
            }
        }
        return res;
    }
}


// 有 o(N^2) 的解法
public List<List<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    
    Map<Integer, List<int[]>> twoSumMap = new HashMap<>(); // for holding visited pair sums. All pairs with the same pair sum are grouped together
    Set<List<Integer>> res = new HashSet<>();  // for holding the results
    
    for (int i = 0; i < num.length; i++) {
        // get rid of repeated pair sums
        if (i > 1 && num[i] == num[i - 2]) continue;
        
        for (int j = i + 1; j < num.length; j++) {
            // get rid of repeated pair sums
            if (j > i + 2 && num[j] == num[j - 2]) continue;

            // for each pair sum, check if the pair sum that is needed to get the target has been visited.              
            if (twoSumMap.containsKey(target - (num[i] + num[j]))) {   
                // if so, get all the pairs that contribute to this visited pair sum.
            List<int[]> ls = twoSumMap.get(target - (num[i] + num[j]));
                
            for (int[] pair : ls) {
                // we have two pairs: one is indicated as (pair[0], pair[1]), the other is (i, j).
                // we first need to check if they are overlapping with each other.
                int m1 = Math.min(pair[0], i);  // m1 will always be the smallest index
                    int m2 = Math.min(pair[1], j);  // m2 will be one of the middle two indices
                    int m3 = Math.max(pair[0], i);  // m3 will be one of the middle two indices
                    int m4 = Math.max(pair[1], j);  // m4 will always be the largest index
                    
                    if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) continue;  // two pairs are overlapping, so just ignore this case
            
            res.add(Arrays.asList(num[m1], num[Math.min(m2, m3)], num[Math.max(m2, m3)], num[m4]));  // else record the result
            }
            }
            
            // mark that we have visited current pair and add it to the corrsponding pair sum group.
            // here we've encoded the pair indices i and j into an integer array of length 2.
            twoSumMap.computeIfAbsent(num[i] + num[j], key -> new ArrayList<>()).add(new int[] {i, j});
        }
    }
    
    return new ArrayList<List<Integer>>(res);
}