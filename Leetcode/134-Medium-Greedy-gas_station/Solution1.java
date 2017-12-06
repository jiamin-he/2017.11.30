/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 22, 2017
 Problem:    Gas Station
 Difficulty: Medium
 Notes:

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.


 */

import java.util.*;

class Solution1 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if(length == 1) return (gas[0] >= cost[0]? 0: -1);
        int startIndex = 0, j = 0;
        while (j < 2 * length ) {
          int temp = 0, i = 0, count = 0;
          while(count < length && j < 2 * length){
            i = (j >= length)? (j-length):j;
            temp += gas[i] - cost[i];
            j++;
            count++;
            if(temp < 0) break;
          }
          startIndex = (j >= length)? (j-length):j;
          if((count == length)&& (temp >= 0)) return startIndex;
          if(j >= 2 * length - 2) break;
        }      
        return -1;
    }

    // 上面那个是我自己写的 很烂 下面这个思路跟我的差不多 但是写的很好！很好理解哈哈 多学习！跟我跑的时间也是一样的！
    public int canCompleteCircuit(int[] gas, int[] cost) {
      for(int i = 0; i < gas.length; i++) {
          gas[i] -= cost[i];
      }
      int sum = 0;
      int result = 0;
      int n = gas.length;
      for(int i = 0; i < n * 2 - 1; i++) {
          sum += gas[i % n];
          if(sum < 0) {
              result = i + 1;
              if(result >= n) {
                  return -1;
              }
              sum = 0;
          }
      }
      return result;
    }

    // 这个好神奇啊！
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int total = gas[start] - cost[start];       
        while (start > end) {
            if (total >= 0) {
                total += gas[end] - cost[end];
                end ++;
            } else {
                start --;
                total += gas[start] - cost[start];
            }
        }
        
        return total >= 0 ? start : - 1;
    }

    public static void main(String[] args) {
        
    }
}
