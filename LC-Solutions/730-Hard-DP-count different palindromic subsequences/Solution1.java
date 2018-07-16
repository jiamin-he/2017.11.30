/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 23, 2017
 Problem:    Count Different Palindromic Subsequences
 Difficulty: Hard
 Notes:
Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.

A subsequence of a string S is obtained by deleting 0 or more characters from S.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

Example 1:
Input: 
S = 'bccb'
Output: 6
Explanation: 
The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.
Example 2:
Input: 
S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
Output: 104860361
Explanation: 
There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
Note:

The length of S will be in the range [1, 1000].
Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.
*/


// 2d dp.
// 119ms 75%
class Solution {
    public int countPalindromicSubsequences(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        char[] chs = s.toCharArray();
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;   
        }

        for(int distance = 1; distance < len; distance++){
            for(int i = 0; i < len - distance; i++){
                int j = i + distance;
                if(chs[i] == chs[j]){
                    int low = i + 1;
                    int high = j - 1;
                    while(low <= high && chs[low] != chs[j]){
                        low++;
                    }
                    while(low <= high && chs[high] != chs[j]){
                        high--;
                    }
                    // multi *2 is because take them(no wrapping) or (wrap them with the first and the last one).
                    if(low > high){ // no same char between them, so add "a" and "aa"
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;  
                    } 
                    else if(low == high){ // 1 same char between them, so add "aa"
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;  
                    }
                    else{  // 2 same char between i and j
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1]; 
                    }
                }
                else{ // first not equal to the last one, (remember to minus the duplicate zone)
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];  //s.charAt(i) != s.charAt(j)
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }

        return dp[0][len - 1];
    }
}

// preprocess to make it improved (O(n^3)) to O(n^2))
// add right next and left next so that you'll find the next duplicate one immediately.
// 96ms 88%
class Solution {
    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        int[] rightNext = new int[len], leftNext = new int[len], rec = new int[4];
        rec[0] = rec[1] = rec[2] = rec[3] = -1;
        for (int i = 0; i < len; i++) {
            leftNext[i] = rec[S.charAt(i) - 'a'];
            rec[S.charAt(i) - 'a'] = i;
        }
        rec[0] = rec[1] = rec[2] = rec[3] = len;
        for (int i = len - 1; i >=0 ; i--) {
            rightNext[i] = rec[S.charAt(i) - 'a'];
            rec[S.charAt(i) - 'a'] = i;
        }
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = 1;
        for (int k = 1; k < len; k++) {
            for (int i = 0, j = i + k; j < len; i++, j++) {
                if (S.charAt(i) != S.charAt(j)) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                } else {
                    int irn = rightNext[i], jln = leftNext[j];
                    if (irn < jln) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[irn + 1][jln - 1];
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + (irn == jln ? 1 : 2);
                    }
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][len - 1];
    }
}