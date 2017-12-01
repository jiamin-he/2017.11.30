/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 26, 2017
 Problem:    Reverse Words in a String
 Difficulty: Medium
 Notes:
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

*/

import java.util.*;

class q4 {

    public String reverseWords(String s) {
        String[] splitS = s.trim().split(" +");
        // trim 为了消除前后多余的空格 whitespaces + 表示多个空格
        Collections.reverse(Arrays.asList(splitS));
        String str = String.join(" ", splitS);
        return str;
    }

    public static void main(String[] args) {
        String n = "    s !! ";
        q4 s1 = new q4();
        String n1 = s1.reverseWords(n);
        System.out.println(n1);  
    }
}
