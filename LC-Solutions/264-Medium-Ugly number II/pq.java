/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 01, 2018
 Problem:    Ugly Number II
 Difficulty: Medium
 Notes:

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/

// 复杂度
// 另一个原因是要维持pq直到得到最后结果的话是 n*log3 (log k)
// 对比math 方法-- math 方法是 O n*3

// but 会溢出，因为拼命乱往大了乘
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        while(--n>0){
            int temp = pq.poll();
            while(!pq.isEmpty() && pq.peek() == temp) {
                pq.poll();
            }
            pq.offer(temp*2);
            pq.offer(temp*3);
            pq.offer(temp*5);
        }
        return pq.poll();
    }
}

// 所以要改用long
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1l);
        for(int i = 1; i < n ; i++){
			// 注意这一行如果写成Long temp = pq.poll()就不work了！！
			// 为什么呢？
			// 因为Long是一个object
			// long是一个primitive type
			// Long的比较用equals
			// long才能直接用==
            long temp = pq.poll();
            while(!pq.isEmpty() && pq.peek() == temp) {
                pq.poll();
            }
            pq.offer(temp*2);
            pq.offer(temp*3);
            pq.offer(temp*5);
        }
        return pq.poll().intValue();
    }
}

// 所以这样写也是对的
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1l);
        for(int i = 1; i < n ; i++){
            Long temp = pq.poll();
            while(!pq.isEmpty() && pq.peek().equals(temp)) {
                pq.poll();
            }
            pq.offer(temp*2);
            pq.offer(temp*3);
            pq.offer(temp*5);
        }
        return pq.poll().intValue();
    }
}