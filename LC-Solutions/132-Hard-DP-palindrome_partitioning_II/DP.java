/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 21, 2017
 Problem:    Palindrome Partitioning II
 Difficulty: hard
 Notes:
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/


// 24ms 76%
// pal[][] and cut[]
class Solution{
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            int min = i; // 初值设i 因为最多i刀一定能ok
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;  // 当 从j 到 i 是 回文的时候 从j砍一刀即可
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1); // 一直更新min
                }
            }
            cut[i] = min; // 把min 赋给array
        }
        return cut[n - 1];
    }
}

// only cut[]
// 21ms 83%
class Solution {
    public int minCut(String s) {
        if(s.length()==0)return 0;
        int[] c = new int[s.length()+1];
        for(int i = 0; i < s.length(); i++)
            c[i] = Integer.MAX_VALUE;  // 给cut们赋初值 其实赋成i也行
        c[s.length()] = -1; // 多设了一个 拿这一个来记录min值 随后面赋给前面对应index的cut
        
        for(int i = s.length() - 1; i >= 0; i--) { // 倒着来
            for(int a = i, b = i; a >= 0 && b < s.length() 
                && s.charAt(a) == s.charAt(b); a--,b++) {
                    c[a]=Math.min(c[a],1+c[b+1])
                };
            for(int a = i, b = i+1; a >= 0 && b < s.length() 
                && s.charAt(a) == s.charAt(b); a--,b++) {
                    c[a]=Math.min(c[a],1+c[b+1]);   
                }
        }

        return c[0];
    }
}

// 5ms 97%
// only cut[] (like the above but from iterative to recursive)
// recursion
class Solution {
    public int minCut(String s){
        int len = s.length();
        int[] dp = new int[len+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[len] = -1;
        dp[len-1] = 0;
        for(int i=s.length()-2; i>=0; i--){
            helper(i, i, dp, s);
            helper(i, i+1, dp, s);
        }
        return dp[0];
    }
    void helper(int start, int end, int[] dp, String s){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            dp[start] = Math.min(dp[start], 1+dp[end+1]);
            start --;
            end ++;
        }
        
    }
    
}
