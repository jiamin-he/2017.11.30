/*
Author: Jiamin
Date: Sep 24, 2018
Problem: Minimum Window Subsequence
Difficulty: hard
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
*/


// O(n^2)
class Solution {
    public String minWindow(String S, String T) {
        char[] sc = S.toCharArray();
        char[] tc= T.toCharArray();
        int[] minVal = new int[2];
        minVal[1] = Integer.MAX_VALUE;
        for(int i = 0; i < sc.length; i++) {
            if(sc[i] == tc[0]) {
                int[] temp = search(sc, i, tc);
                if(temp[1] < minVal[1]) minVal = temp;
            }
        }
        return minVal[1] == Integer.MAX_VALUE? "":S.substring(minVal[0], minVal[0] + minVal[1]);
    }
    
    public int[] search(char[] sc, int start, char[] tc) {
        int tIndex = 0, i = start;
        for(; i < sc.length && tIndex < tc.length; i++) {
            if(sc[i] == tc[tIndex]) {
                tIndex++;
            }
        }
        if(tIndex == tc.length) {
            return new int[] {start, i - start};
        }
        return new int[] {0, Integer.MAX_VALUE};
    }
}


// dp
class Solution {
    public String minWindow(String S, String T) {
        // dp[i][j] stores the starting index of the substring where T has length i and S has length j.
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++)
            dp[0][j] = j + 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else dp[i][j] = dp[i][j - 1];
            }
        }
        
        int start = 0, len = n + 1;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] - 1;
                    len = j - dp[m][j] + 1;
                }
            }
        }
        return len == n + 1 ? "" : S.substring(start, start + len);
    }
}


class Solution {
    public String minWindow(String S, String T) {
        int p1 = 0, p2 = 0;
        String min = S+"a";
        int l = S.length();
        int idx = 0;
        while(p1 < l){
            if(S.charAt(p1) == T.charAt(idx)){
                p2 = p1+1;
                idx++;
                while(idx < T.length() && p2 < l){
                    if(S.charAt(p2) == T.charAt(idx)){
                        idx++;
                    }
                    p2++;
                }
                if(idx == T.length()){
                    idx--;
                    p1 = p2-1;
                    while(idx >= 0){
                        if(S.charAt(p1) == T.charAt(idx)) idx--;
                        p1--;
                    }
                    p1++;
                    idx++;
                    if((p2-p1)<min.length()){
                        min = S.substring(p1,p2);
                    }
                }else{
                    break;
                }
            }
            p1++;
        }
        return min.length()>S.length()?"":min;
    }
}