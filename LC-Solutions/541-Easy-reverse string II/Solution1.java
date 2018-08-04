/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 28, 2017
 Problem:    reverse string
 Difficulty: Easy
 Notes:

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
*/


// 6ms 61%
class Solution {
    public String reverseStr(String s, int k) {
        char[] sc = s.toCharArray();
        int i = 0, m = 2*k-1, j = k-1;
        while(m < sc.length) {
            while (i<j) {
                char temp = sc[i];
                sc[i] = sc[j];
                sc[j] = temp;
                i++;
                j--;
            }
            i = m+1;
            m+=2*k;
            j = m-k;
        }
        if( j >= sc.length) j = sc.length -1;
        while (i<j) {
            char temp = sc[i];
            sc[i] = sc[j];
            sc[j] = temp;
            i++;
            j--;
        }
        return new String(sc);
    }
}

// July 22nd 2018
// 3ms 100%
class Solution {
    public String reverseStr(String s, int k) {
        int start = 0;
        char[] sc = s.toCharArray();
        while(start < s.length()) {
            if(s.length()-start < k) {
                reverse(sc, start, sc.length-1);
            } else {
                reverse(sc, start, start+k-1);
            }
            start += 2*k;
        }
        return new String(sc);
    }
    
    public void reverse(char[] s, int start, int end) {
        while(start < end ) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}