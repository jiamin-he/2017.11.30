/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 11, 2017
 Problem:    Intersection of Two Arrays
 Difficulty: Easy
 Notes:

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.


 Solution: 2 index? No, you should traverse the short array firstly, 
 and then see if there is any of them in the second array.

 So firstly, we'll try Hashmap to traverse the array.
*/

class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashMap<Integer,Boolean> map1 = new HashMap<>();
       HashMap<Integer,Boolean> intersectMap = new HashMap<>();

       for (int i=0; i<nums1.length ; i++ ) {
           if (!map1.containsKey(nums1[i])) {
               map1.put(nums1[i],true);
           }
       }

       for (int j=0; j<nums2.length ; j++ ) {
           if (map1.containsKey(nums2[j]) && !intersectMap.containsKey(nums2[j])) {
               intersectMap.put(nums2[j],true);
           }
       }

       int[] result = new int[intersectMap.size()];
       int i=0;
       for (Integer e : intersectMap.keySet() ) {
           result[i] = e;
           i++;
       }
       return result;
    }
}
