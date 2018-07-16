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
    public int minSwapsCouples(int[] row) {
        int[] pos = new int[row.length];
        boolean[] visited = new boolean[row.length];
        for(int i = 0; i < row.length; i++) {
            pos[row[i]] = i;
        }
        
        int count = 0;
        for(int i = 0; i < row.length;) {
            if(pos[i] % 2 == 0 && (i<row.length-1 && pos[i+1] !=pos[i]+1)) {
                swap(pos,row,i,true);
                count++;
            } else if (pos[i]%2 != 0 &&(i<row.length-1 && pos[i+1] !=pos[i]-1)) {
                swap(pos,row,i,false);
                count++;
            }
            i += 2;
        }
        return count;
    }
    
    public void swap (int[] pos, int[] row, int i, boolean even) {
        int seat = even? pos[i]+1: pos[i]-1;
        int temp1 = pos[i+1];  // person i+1 's original seat
        pos[i+1] = seat;
        //pos[i+1] = pos[i]+1; // he should sit to this seat
        pos[row[seat]] = temp1;
        //pos[row[pos[i]+1]] = temp1; // the person on this seat is who. and then he sits to that seat. so they swapped the seat.
        int temp2 = row[pos[i+1]]; // person i+1's current seat originally sits whom.
        row[pos[i+1]] = i+1; // now sits person i+1
        row[temp1] = temp2; // person i+1's original seat now sits that one.
    }
}