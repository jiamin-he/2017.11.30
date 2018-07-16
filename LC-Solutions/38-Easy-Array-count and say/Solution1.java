/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 27, 2017
 Problem:    count and say
 Difficulty: easy
 Notes:

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"


*/

class Solution {
    public String countAndSay(int n) {
        int cur = 1;
        String s = "1";
        while(cur < n){
            int count=1;
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<s.length();i++){
                if(s.charAt(i) == s.charAt(i-1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(s.charAt(i-1));
                    count=1;
                }
            }
            sb.append(count);
            sb.append(s.charAt(s.length()-1));
            s=sb.toString();
            cur++;
        }
        return s;
        
    }
}

// Jun 24, review
class Solution {
    public String countAndSay(int n) {
        if (n<0) return "";
        String ori = "1";
        
        while(--n > 0){
            int len = ori.length();
            int counter = 1;
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i<len; i++) {
                if(ori.charAt(i) == ori.charAt(i-1)) {
                    counter++;
                } else {
                    sb.append(counter).append(ori.charAt(i-1));
                    counter = 1;
                }
            }
            sb.append(counter).append(ori.charAt(len-1));
            ori = sb.toString();
        }
        return ori;
    }
}
