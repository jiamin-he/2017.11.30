/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Find the Celebrity

Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
*/


/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// 15ms 42%
// 注意candidate的定义！！！很重要！！！
// 思考清楚了就没有问题！！！
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(candidate,i)) candidate = i;
        }
        for(int i = 0; i < n; i++) {
            if((i!=candidate && knows(candidate, i)) || (i!= candidate && !knows(i,candidate)))
                return -1;
        }
        return candidate;
    }
}


// 9ms 91%
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
            // 其实下面这个if是没有用的 因为满足上面的话 也就是 candidate不认识i
            // 那这些i自然也已经不可能是candiate了
            if(!knows(i, candidate)) {
                candidate = i;
            }
        }
        // 这么放是不对的！！！这样是终止for loop的条件啊！！！
        // for(int i = 0; i < n && i != candidate; i++) {
        //     if(knows(candidate, i) || !knows(i, candidate)) {
        //         return -1;
        //     }
        // }
        // 应该这样写
        for(int i = 0; i < n; i++) {
            if((i!=candidate && knows(candidate, i)) || (i!= candidate && !knows(i,candidate)))
                return -1;
        }

        return candidate;
    }
}