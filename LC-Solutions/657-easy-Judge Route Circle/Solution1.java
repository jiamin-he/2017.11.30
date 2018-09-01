/*
Author: Jiamin
Date: Aug 30, 2018
Problem: Judge Route Circle
Difficulty: easy

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:

Input: "UD"
Output: true
 

Example 2:

Input: "LL"
Output: false
*/

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] sc = moves.toCharArray();
        for(char c: sc){
            if(c == 'U') {
                y--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            } else {
                y++;
            }
        }
        return x==0&&y==0;
    }
}