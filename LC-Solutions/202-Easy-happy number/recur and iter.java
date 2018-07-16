/*
Author: Jiamin
Date: Jan 05, 2017
Problem: happy number
Difficulty: easy
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1


*/

// 5ms 19%
// recursively
class Solution {
    public boolean isHappy(int n) {
        return helper(n,new HashSet<Integer>());
    }
    
    public boolean helper(int n, Set<Integer> visited) {
        int sum = 0, digit = 0;
        while(n > 0) {
            digit = n%10;
            sum += digit*digit;
            n /= 10;
        }
        if(sum == 1) return true;
        if(visited.contains(sum)) return false;
        else visited.add(sum);
        return helper(sum,visited);
    }
}

// 5ms 19%
//iteratively
class Solution {
    public boolean isHappy(int n){
        Set<Integer> visited = new HashSet<>();
        int sum = 0;
        while(sum != 1) {
            int digit = 0;
            sum = 0;
            while (n > 0) {
                digit = n%10;
                sum += digit*digit;
                n/=10;
            }
            if(visited.contains(sum)) return false;
            else visited.add(sum);
            n = sum;
        }
        return true;
    }
}
