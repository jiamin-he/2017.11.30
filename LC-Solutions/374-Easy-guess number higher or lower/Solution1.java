/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 25, 2017
 Problem:    guess number higher or lower
 Difficulty: easy
 Notes:
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.

*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1, j = n;
        while(i < j) {
            int mid = i+(j-i)/2;
            int res = guess(mid);
            if(res == 0) return mid;
            else if(res == -1) j = mid;
            else i=mid+1;
        }
        return i;
        
    }
}


// 2018 July 21st review
// 0ms 100% 

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n;
        int num = 0;
        while(start <= end && num == 0) {
            int mid = start + (end-start) /2;
            int temp = guess(mid);
            if(temp == 0) {
                num = mid;
            } else if(temp > 0) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return num;
    }
}