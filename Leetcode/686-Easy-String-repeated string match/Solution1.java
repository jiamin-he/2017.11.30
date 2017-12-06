/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 11, 2017
 Problem:    repeated string match
 Difficulty: easy
 Notes:

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.



*/

import java.util.*;

class Solution1 {

    public int repeatedStringMatch(String A, String B) {

    int count = 0;
    StringBuilder sb = new StringBuilder();
    while (sb.length() < B.length()) {
        sb.append(A);
        count++;
    }
    if(sb.toString().contains(B)) return count;
    if(sb.append(A).toString().contains(B)) return ++count;
    return -1;
    }

    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        int count = 1;
        while(sb.indexOf(B)<0){
            if(sb.length()-A.length()>B.length()){
                return -1;
            }
            sb.append(A);
            count++;
        }
        
        return count;
    }

    public int repeatedStringMatch(String a, String b) {
        String as = a;
        for (int rep = 1; rep <= b.length() / a.length() + 2; rep++, as += a)
            if (as.indexOf(b) != -1) return rep;
        return -1;
    }
}
