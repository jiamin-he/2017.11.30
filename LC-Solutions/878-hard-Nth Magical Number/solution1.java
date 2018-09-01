/*
Author: Jiamin
Date: July 29, 2018
Problem: Nth Magical Number
Difficulty: hard

A positive integer is magical if it is divisible by either A or B.

Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.

 

Example 1:

Input: N = 1, A = 2, B = 3
Output: 2
Example 2:

Input: N = 4, A = 2, B = 3
Output: 6
Example 3:

Input: N = 5, A = 2, B = 4
Output: 10
Example 4:

Input: N = 3, A = 6, B = 4
Output: 8
 

Note:

1 <= N <= 10^9
2 <= A <= 40000
2 <= B <= 40000
 
*/

// TLE
class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        List<Integer> list = new ArrayList<>();
        int copyA = A, copyB = B;
        while(list.size() < N) {
            if(copyA < copyB) {
                if(!list.contains(copyA))
                    list.add(copyA);
                copyA += A;
            } else {
                if(!list.contains(copyB))
                    list.add(copyB);
                copyB += B;
            }
        }
        return list.get(N-1)%1000000007;
    }
}

// TLE
class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int M = 1000000007;
        List<Integer> list = new ArrayList<>();
        int copyA = A, copyB = B;
        if(A==B || A%B == 0 || B%A==0){
            A = Math.min(A,B);
            long temp = ((long)(N%M)*(A%M))%M;
            System.out.println(temp);
            return (int)temp;
        } 
        while(list.size() < N) {
            while(copyA < copyB) {
                if(!list.contains(copyA))
                    list.add(copyA);
                copyA += A;
            }
            while(copyB <= copyA) {
                if(!list.contains(copyB))
                    list.add(copyB);
                copyB += B;
            }
        }
        return list.get(N-1)%M;
    }
}

// if counting one at each will TLE
// then we should consider counting M at each  (L: least common multiple)
// how?
// https://leetcode.com/problems/nth-magical-number/solution/
class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A / gcd(A, B) * B;
        int M = L / A + L / B - 1;
        int q = N / M, r = N % M;

        long ans = (long) q * L % MOD;
        if (r == 0)
            return (int) ans;

        int[] heads = new int[]{A, B};
        for (int i = 0; i < r - 1; ++i) {
            if (heads[0] <= heads[1])
                heads[0] += A;
            else
                heads[1] += B;
        }

        ans += Math.min(heads[0], heads[1]);
        return (int) (ans % MOD);
    }

    public int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}

// binary search
class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A / gcd(A, B) * B;

        long lo = 0;
        long hi = (long) 1e15;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            // If there are not enough magic numbers below mi...
            if (mi / A + mi / B - mi / L < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return (int) (lo % MOD);
    }

    public int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}