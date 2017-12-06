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


 Solution: sort and then merge. Fast.

*/

class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);

      int i=0, j=0;
      int[] temp = new int[nums1.length]; //此处也可以用HashSet 储存值
      int index=0;

      while (i < nums1.length && j <nums2.length){
        if (nums1[i] == nums2[j]) {
          if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
          }

          i++;
          j++;
        } else if (nums1[i] < nums2[j]) {
          i++;
        } else {
          j++;
        }
      }

      int[] result = new int[index];
      for (int k=0; k<index ; k++) {
        result[k] = temp[k];
      }

      return result;
    }
}
