/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 1, 2018
 Problem:    Next Closest Time
 Difficulty: Medium
 Notes:

Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.


*/

// 3ms 100%
class Solution {
    public String nextClosestTime(String time) {
        int[] map = new int[10];
        int minVal = Integer.MAX_VALUE;
        char[] sc = time.toCharArray();
        for(char c: sc) {
            if(c == ':') continue;
            int cur = c-'0';
            map[c-'0']++;
            if(cur < minVal) minVal = cur;
        }
        for(int i = sc.length-1; i >= 0; i--) {
            char c = sc[i];
            if(c == ':') continue;
            for(int j = c-'0'+1; j <= 9; j++) {
                if(map[j] > 0) {
                    sc[i] = (char)(j+'0');
                    if(validate(sc)) {
                        return new String(sc);
                    } else {
                        break;   
                    }
                }
            }
            sc[i] = (char)(minVal+'0');
        }
        for(int j = 0; j < sc.length; j++) {
            char c = sc[j];
            if(c == ':') continue;
            sc[j] = (char)(minVal+'0');
        }
        return new String(sc);
    }
    
    public boolean validate(char[] sc) {
        int hour = (sc[0]-'0') * 10 + (sc[1] -'0');
        int min = (sc[3]-'0') * 10 + (sc[4] -'0');
        return hour >= 0 && hour < 24 && min >= 0 && min < 60;
    }
}