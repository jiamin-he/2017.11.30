/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 8, 2017
 Problem:    valid square
 Difficulty: medium
 Notes:
Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.
*/


class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] res = new int[6];
        res[0] = (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
        res[1] = (p1[0]-p3[0])*(p1[0]-p3[0])+(p1[1]-p3[1])*(p1[1]-p3[1]);
        res[2] = (p1[0]-p4[0])*(p1[0]-p4[0])+(p1[1]-p4[1])*(p1[1]-p4[1]);
        res[3] = (p3[0]-p2[0])*(p3[0]-p2[0])+(p3[1]-p2[1])*(p3[1]-p2[1]);
        res[4] = (p4[0]-p2[0])*(p4[0]-p2[0])+(p4[1]-p2[1])*(p4[1]-p2[1]);
        res[5] = (p3[0]-p4[0])*(p3[0]-p4[0])+(p3[1]-p4[1])*(p3[1]-p4[1]);
        int a = res[0], b = 0, i = 1, count1 = 1, count2 = 1;
        while(i < 6 && res[i++] == a ) count1++;
        b = res[i-1];
        for(; i < 6; i++){
            if(res[i] == a) count1++;
            if(res[i] == b) count2++;
        }
        if((count1 == 4 && count2 == 2 && a < b) ||
           (count2 == 4 && count1 == 2 && a > b)) 
            return true;
        return false;
    }
}
