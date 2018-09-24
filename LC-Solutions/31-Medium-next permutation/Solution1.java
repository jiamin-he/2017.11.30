/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 10, 2018
 Problem:    next permutation
 Difficulty: medium
 Notes:

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1


*/


// 14ms 97%
class Solution {
    public void nextPermutation(int[] nums) {
        int index = 0;
        boolean swap = false;
        for(int i = nums.length-1; i> 0; i--){
            if(nums[i-1]<nums[i]) {
                index = i-1;
                swap = true;
                break;
            }
        }

        int swapPos = index+1;
        for(int i= index+1; i < nums.length; i++){
            if(nums[i] > nums[index]){
                if(nums[i] <= nums[swapPos]) {
                    swapPos = i;   
                }
            } else {
                break;
            } 
        }
        // Sep 23rd 2018 review, this part
        // int swapPos = index+1;
        // for(int i= nums.length - 1; i > index + 1; i--){
        //     if(nums[i] > nums[index]){
        //         swapPos = i;
        //         break;
        //     }
        // }

        System.out.println(swapPos);
        if(swap) {
            swap(nums,index,swapPos);
            reverse(nums,index+1);
        } else {
            reverse(nums,0);
        }
    }
    public void swap(int[] nums, int p1, int p2){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
    public void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}