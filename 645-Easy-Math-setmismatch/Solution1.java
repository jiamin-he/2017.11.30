/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 28, 2017
 Problem:    Set Mismatch
 Difficulty: Easy
 Notes:
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

 */


// 可以sort 然后顺着扫一遍 重复的是dup 下一个数比前一个数相差大于1的是missing 时间nlogn 空间logn sorting需要logn的空间
// hashmap存值--类似多建一个array存值了 时间n 空间n
// here方法 时间n 空间n
// 用constant space节省空间 在原数组基础上进行修改 遇到了变成-1 如果当前小于0 证明是duplicate 再重新扫一遍 大于0的是missing 很巧妙的方法！ 时间n 空间1
//

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length+1];
        int[] temp = new int[2];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
            if(count[nums[i]] == 2) temp[0] = nums[i];
        }
        for(int i = 1; i < count.length; i++){
            if(count[i] == 0) temp[1] = i;
        }
        return temp;
    }
}
