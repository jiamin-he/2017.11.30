/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 04, 2018
 Problem:    Decode Ways II
 Difficulty: Hards
 Notes:
A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.
*/

// 39ms 40%
class Solution {
    int M = 1000000007;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        // 设成long很重要！！！
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'? 0: (s.charAt(0) == '*'? 9:1);
        for( int i = 2; i < dp.length; i++) {
            char first = s.charAt(i-1);
            char second = s.charAt(i-2);
            if(first == '*') {
                dp[i] =(dp[i] + dp[i-1]*9)%M;
                if(second == '*') {
                    dp[i] = (dp[i] +dp[i-2]*15)%M;
                } else if (second == '1') {
                    dp[i] =(dp[i] + dp[i-2]*9)%M;
                } else if (second == '2') {
                    dp[i] =(dp[i] + dp[i-2]*6)%M;
                }
            } else {
                if(first != '0') {
                    dp[i] =(dp[i] + dp[i-1])%M;
                }
                if(second == '*') {
                    if(first <= '6') {
                        dp[i] =(dp[i] + dp[i-2]*2)%M;
                    } else {
                        dp[i] =(dp[i] + dp[i-2])%M;
                    }
                } else {
                    int temp = (second-'0')*10+(first -'0');
                    if(temp >= 10 && temp <= 26) {
                        dp[i] =(dp[i] + dp[i-2])%M;
                    }
                }
            }
            
        }
        return (int)dp[dp.length - 1];
    }
}

// 空间优化
// 但是时间跟上面一样
class Solution {
    int M = 1000000007;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        long pprev = 1;
        long prev = s.charAt(0)=='0'? 0: (s.charAt(0) == '*'? 9:1);
        for( int i = 2; i <= s.length(); i++) {
            char first = s.charAt(i-1);
            char second = s.charAt(i-2);
            long cur = 0;
            if(first == '*') {
                cur =(cur + prev*9)%M;
                if(second == '*') {
                    cur = (cur +pprev*15)%M;
                } else if (second == '1') {
                    cur =(cur+ pprev*9)%M;
                } else if (second == '2') {
                    cur =(cur + pprev*6)%M;
                }
            } else {
                if(first != '0') {
                    cur =(cur+ prev)%M;
                }
                if(second == '*') {
                    if(first <= '6') {
                        cur =(cur+ pprev*2)%M;
                    } else {
                        cur =(cur + pprev)%M;
                    }
                } else {
                    int temp = (second-'0')*10+(first -'0');
                    if(temp >= 10 && temp <= 26) {
                        cur =(cur + pprev)%M;
                    }
                }
            }
            pprev = prev;
            prev = cur;
        }
        return (int)prev;
    }
}