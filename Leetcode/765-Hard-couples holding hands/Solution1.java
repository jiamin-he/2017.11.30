/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 13, 2017
 Problem:    Couples Holding Hands
 Difficulty: Hard
 Notes:

N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.
*/
class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int[] mine: mines) {
            grid[mine[0]][mine[1]] = 1;
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) 
                q.offer(new int[] {i,j});
        }
        int level = 0, maxLevel = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            level = 0;
            int x = cur[0], y = cur[1];
            if (grid[x][y] == 0 ) level++;
            int i = 1;
            while (((x < N-i) && grid[x+i][y]==0) && ((y < N-i) && grid[x][y+i]==0) 
                && ((x-i >= 0) && grid[x-i][y]==0) && ((y-i >= 0) && grid[x][y-i]==0) ) {
                level ++;
                i++;
            }
            if(level > maxLevel) maxLevel = level;
        }
        return maxLevel;
    }
}