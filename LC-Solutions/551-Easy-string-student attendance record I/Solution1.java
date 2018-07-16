/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 08, 2017
 Problem:    Student Attendance Record I
 Difficulty: Easy
 Notes:

You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False


*/


// 12ms 17%
class Solution {
    public boolean checkRecord(String s) {
        boolean flag = false;
        int countL = 0, len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c=='A') {
                if(flag) return false;
                flag = true;
            } else if (c == 'L' && (i < len-2 && s.charAt(i+1)=='L' && s.charAt(i+2) == 'L')) 
                return false;
        }
        return true;
    }
}

// or
class Solution {
    public boolean checkRecord(String s) {
        return s.indexOf("A")==s.lastIndexOf("A") && (!s.contains("LLL"));
    }
}