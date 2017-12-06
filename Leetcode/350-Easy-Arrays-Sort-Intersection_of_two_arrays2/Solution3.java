/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 12, 2017
 Problem:    Intersection of Two Arrays II
 Difficulty: Easy
 Notes:

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 Solution: What is different from last question, is that "repetition". so cannot use hashset but should use hashmap to record the times of the intersected number.

*/

class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1=0;
        int p2=0;
        List<Integer> res=new ArrayList<Integer>();
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]==nums2[p2]){
                res.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1]<nums2[p2])
                p1++;
            else 
                p2++;
        }
        int[] t=new int[res.size()];
        for(int i=0;i<res.size();i++)
            t[i]=res.get(i);
            
        return t;
    }
}
