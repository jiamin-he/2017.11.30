/*
Author: Jiamin
Date: Dec 19, 2017
Problem: Find the Celebrity

Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
*/

// 13ms 70%
// similar to the "two passes" solution
// just save some time in the first pass because it uses two pointers to scan it, much faster.
public int findCelebrity(int n) {
    if (n < 0) return 0;
    int l = 0, r = n - 1;
    while (l < r) {
        if (knows(l, r)) l++;
        else r--;
    }
    int i = 0;
    while (i < n) {
        if (i != l && (knows(l, i) || !knows(i, l))) return -1;
        i++;
    }
    return l;
}