/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 30, 2017
 Problem:    remove boxes
 Difficulty: Hard
 Notes:

Given several boxes with different colors represented by different positive numbers. 
You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
Find the maximum points you can get.

Example 1:
Input:

[1, 3, 2, 2, 2, 3, 4, 3, 1]
Output:
23
Explanation:
[1, 3, 2, 2, 2, 3, 4, 3, 1] 
----> [1, 3, 3, 4, 3, 1] (3*3=9 points) 
----> [1, 3, 3, 3, 1] (1*1=1 points) 
----> [1, 1] (3*3=9 points) 
----> [] (2*2=4 points)
Note: The number of boxes n would not exceed 100.

*/

// recursively update dp once at a time.
// 30 ms 67%
// space: O n3
// time: O n3
// top down dp
// we need this value, so we go to compute this value
class Solution {
    
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return countPoints(dp, 0,n-1,0,boxes);
    }
    public int countPoints (int[][][] dp, int l, int r, int k,int[] boxes){
        if(l > r) return 0;
        while(l < r && boxes[r] == boxes[r-1]){
            r--;
            k++;
        }
        if(dp[l][r][k] != 0){
            return dp[l][r][k];    
        }
        dp[l][r][k] = countPoints(dp, l, r-1, 0, boxes) + (k+1) * (k+1);
        for(int i = l; i < r; i++){
            if(boxes[i] == boxes[r]){
                dp[l][r][k] = Math.max(dp[l][r][k], countPoints(dp, l, i, k+1, boxes) + countPoints(dp, i+1, r-1, 0, boxes));
            }
        }
        return dp[l][r][k];
    }
}


// bottom-up
// we assign value to each of them and gradually get what we need at last.

public int removeBoxes(int[] boxes) {
    int n = boxes.length;
    int[][][] dp = new int[n][n][n];
        
    for (int j = 0; j < n; j++) {
        for (int k = 0; k <= j; k++) {
            dp[j][j][k] = (k + 1) * (k + 1);
        }
    }
        
    for (int l = 1; l < n; l++) {
        for (int j = l; j < n; j++) {
            int i = j - l;
                
            for (int k = 0; k <= i; k++) {
                int res = (k + 1) * (k + 1) + dp[i + 1][j][0];
                    
                for (int m = i + 1; m <= j; m++) {
                    if (boxes[m] == boxes[i]) {
                        res = Math.max(res, dp[i + 1][m - 1][0] + dp[m][j][k + 1]);
                    }
                }
                    
                dp[i][j][k] = res;
            }
        }
    }
    
    return (n == 0 ? 0 : dp[0][n - 1][0]);
}