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


 Solution: HashSet instead of HashMap. A little bit faster.

*/

class Solution3 {
    public int[] intersection(int[] nums1, int[] nums2) {
      Set<Integer> set = new HashSet<>();
      Arrays.sort(nums2);

      for (Integer num: nums1 ) {
           
           if (binarySearch(nums2, num)) {
             set.add(num);
           }
         }  

      int i=0;
      int[] result = new int[set.size()];
      for (Integer e : set) {
         result[i++] = e;
       } 

      return result;

    }


    public boolean binarySearch(int[] nums, int target){
      int low=0;
      int high = nums.length -1;

      while(low <= high){
        int mid = low + (high-low)/2;
        if (nums[mid] == target) {
          return true;
        } else if (nums[mid]>target) {
          high = mid -1;
        } else {
          low = mid +1;
        }

      }

      return false;
    }
}
