/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 8, 2017
 Problem:    can place flower
 Difficulty: easy
 Notes:
Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.
*/

// mine 跑得很慢 超慢 11%
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        for(int i = 0; i < flowerbed.length ; i++){
            if(flowerbed[i] == 1) i++;
            else if(i < flowerbed.length - 1 && flowerbed[i+1] == 0) {n--;i++;}
            else if (i == flowerbed.length - 1 ) n--;
            else i=i+2;
            if(n == 0) return true;
        }
        return false;
    }
}

// 这个快很多 85% +
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        for(int i = 0; i < flowerbed.length ; i++){
           if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) 
              && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
               n--;
               if(n == 0) return true;
               flowerbed[i] = 1;
           }
        }
        return false;
    }
}
