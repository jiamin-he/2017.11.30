/*
Author: Jiamin
Date: Jan 08, 2017
Problem: smallest range
Difficulty: hard

You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

Example 1:
Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Note:
The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.

*/

// 792ms 0%
// O(mn*mlogm)
class Solution {
    class number{
        int val;
        int group;
        public number(int v, int g){
            val = v;
            group = g;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] index = new int[nums.size()];
        int[] res = new int[] {0,Integer.MAX_VALUE};
        number[] cache = new number[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            cache[i] = new number(nums.get(i).get(0),i);
        }
        while(true) {
            Arrays.sort(cache, new Comparator<number>(){
               public int compare(number n1, number n2) {
                   return n1.val - n2.val;
               } 
            });
            int left = cache[0].val;
            int right = cache[cache.length-1].val;
            if((right-left) < (res[1]-res[0])) {
                res[0] = left; 
                res[1] = right;
            }
            int group = cache[0].group;
            if(index[group] < nums.get(group).size()-1) {
                
                index[group]++;
                cache[0] = new number(nums.get(group).get(index[group]),group);
            } else {
                break;
            }
        }
        return res;
    }
}
