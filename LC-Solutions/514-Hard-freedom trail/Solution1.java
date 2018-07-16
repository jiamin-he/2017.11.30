/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Freedom Trail
 Difficulty: Hard
 Notes:
In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.

Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters in the keyword.

Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all the characters in the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key aligned at 12:00 direction and then by pressing the center button. 
At the stage of rotating the ring to spell the key character key[i]:
You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the rotation is to align one of the string ring's characters at the 12:00 direction, where this character must equal to the character key[i].
If the character key[i] has been aligned at the 12:00 direction, you need to press the center button to spell, which also counts as 1 step. After the pressing, you could begin to spell the next character in the key (next stage), otherwise, you've finished all the spelling.
Example:


Input: ring = "godding", key = "gd"
Output: 4
Explanation:
 For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
 For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
 Also, we need 1 more step for spelling.
 So the final output is 4.
Note:
Length of both ring and key will be in range 1 to 100.
There are only lowercase letters in both strings and might be some duplcate characters in both strings.
It's guaranteed that string key could always be spelled by rotating the string ring.

*/

// 11ms 64%
class Solution {
    public int findRotateSteps(String ring, String key) {
        return helper(ring.toCharArray(), key, 0,0);
    }
    
    public int helper(char[] rc, String key, int i, int cur) {
        if(cur >= key.length()) return 0;
        char goal = key.charAt(cur);
        int res = Integer.MAX_VALUE;
        for(int j = 0; j< (rc.length+1)/2;j++) {
            int plus = i+j >= rc.length? i+j-rc.length: i+j;
            int minus = i-j < 0? rc.length+i-j:i-j;
            if(rc[plus] == goal) {
                System.out.println("plus " + cur + " " + res + " " + i + " " +plus); 
                res = Math.min(res, j+1+helper(rc,key,plus,cur+1));   
            }
            // System.out.println(res);
            if(rc[minus] == goal){
                System.out.println("minus " + cur + " " + res+ " " + i + " " + minus);
                res = Math.min(res, j+1+helper(rc,key,minus,cur+1));
            } 
            // System.out.println(res);
        }
        System.out.println("finish " + res + " " + cur + " " + i);
        return res;
    }
}


//  O m*n^2
public class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        
        return dp[0][0] + m;
    }
}

// O mn
public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        int[][] dp = new int[m + 1][n];
        int[][] clock = preproc(ring, 1), anti = preproc(ring, -1);
        for (int i = m - 1; i >= 0; --i) {
            int idx = key.charAt(i) - 'a';
            for (int j = 0; j < n; ++j) { // fill dp[i][j]
                int p = clock[j][idx];
                int q = anti[j][idx];
                dp[i][j] = Math.min(dp[i + 1][p] + (j + n - p) % n, dp[i + 1][q] + (q + n - j) % n);
            }
        }
        return dp[0][0] + m;
    }
    int[][] preproc(String r, int inc) {
        int n = r.length();
        int[][] ans = new int[n][26];
        int[] map = new int[26];
        for (int i = 0, j = 0; j < n * 2 - 1; ++j) {
            map[r.charAt(i) - 'a'] = i;
            System.arraycopy(map, 0, ans[i], 0, 26);
            i = (i + inc + n) % n;
        }
        return ans;
    }



// dfs + memorization
public class Solution {
    Map<String, Map<Integer, Integer>> memo;
    public int findRotateSteps(String ring, String key) {
        memo = new HashMap<>();
        return dfs(ring, key, 0);
    }
    
    private int findPos(String ring, char ch){ // find first occurrence clockwise
        return ring.indexOf(ch);
    }
    
    private int findBackPos(String ring, char ch){ //find first occurrence  anti-clockwise
        if(ring.charAt(0) == ch) return 0;
        for(int i = ring.length()-1;i>0;i--){
            if(ring.charAt(i) == ch) return i;
        }
        return 0;
    }
    
    private int dfs(String ring, String key, int i){
        if(i == key.length()) return 0;
        int res = 0;
        char ch = key.charAt(i);
        if(memo.containsKey(ring) && memo.get(ring).containsKey(i)) return memo.get(ring).get(i);
        int f = findPos(ring, ch);
        int b = findBackPos(ring, ch);
        int forward = 1+f+dfs(ring.substring(f)+ring.substring(0, f), key, i+1);
        int back = 1+ring.length()-b + dfs(ring.substring(b)+ring.substring(0, b),key, i+1);
        res = Math.min(forward, back);
        Map<Integer, Integer> ans = memo.getOrDefault(ring, new HashMap<>());
        ans.put(i, res);
        memo.put(ring, ans);
        return res;
    }
}