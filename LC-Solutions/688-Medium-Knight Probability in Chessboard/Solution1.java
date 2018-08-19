/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 12, 2018
 Problem:    Knight Probability in Chessboardlongest univalue path
 Difficulty: medium
 Notes:

On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.

Example:
Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Note:
N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.
*/

// TLE
// 想想是怎么变成最下面的那个不超时的超快递归的！！
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[] res = new int[1];
        helper(N, K, r, c, res);
        double total = Math.pow(8,K);
        return res[0]/total;
    }
    
    public void helper(int N, int K, int r, int c, int[] res) {
        if(K == 0 ){
            if(r>= 0 && r< N && c>= 0 && c< N){
                res[0]++;
            }
            return;
        }
        if(r< 0 || r>=N || c<0 || c>= N) return;
        
        
        helper(N, K-1, r+2, c+1, res);
        helper(N, K-1, r-2, c+1, res);
        helper(N, K-1, r+2, c-1, res);
        helper(N, K-1, r-2, c-1, res);
        helper(N, K-1, r+1, c+2, res);
        helper(N, K-1, r+1, c-2, res);
        helper(N, K-1, r-1, c+2, res);
        helper(N, K-1, r-1, c-2, res);
    }
}


// dp
// 7ms 74%
// time 8KN^2
// space N^2
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
        
        if(K == 0){
            if(r >= 0 && r < N && c >= 0 && c< N) return 1.0;
            else return 0.0;
        }
        
        for(int j = 0; j < N; j++) {
            for(int h = 0; h < N; h++) {
                for (int k = 0; k < 8; k++) {
                    int newj = j + dr[k];
                    int newh = h + dc[k];
                    if (0 <= newj && newj < N && 0 <= newh && newh < N) {
                        dp[j][h] ++;
                    }
                }
            }
        }
        
        for(int i = 2; i <= K; i++) {
            double[][] next = new double[N][N];
            for(int j = 0; j < N; j++) {
                for(int h = 0; h < N; h++) {
                    for (int k = 0; k < 8; k++) {
                        int newj = j + dr[k];
                        int newh = h + dc[k];
                        if (0 <= newj && newj < N && 0 <= newh && newh < N) {
                            next[j][h] += dp[newj][newh];
                        }
                    }
                }
            }
            dp = next;
        }
        
        double total = Math.pow(8,K);
        return dp[r][c]/total;
    }
}


// recursively memorization
// the improved version as my TLE version
// time 8^k with memorization optimzation
// space KN^2
class Solution {
    private int[][]dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    private double[][][] dp;
    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[N][N][K + 1];
        return find(N,K,r,c);
    }
    public double find(int N,int K,int r,int c){
        if(r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;
        if(K == 0)  return 1;
        if(dp[r][c][K] != 0) return dp[r][c][K];
        double rate = 0;
        for(int i = 0;i < dir.length;i++)   rate += 0.125 * find(N,K - 1,r + dir[i][0],c + dir[i][1]);
        dp[r][c][K] = rate;
        return rate;
    }
}