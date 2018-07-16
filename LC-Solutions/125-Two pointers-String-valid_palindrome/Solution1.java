/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 21, 2017
 Problem:    Valid Palindrome
 Difficulty: easy
 Notes:
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

*/

// 8 ms 64%
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) return true;
        int i = 0, j = s.length()-1;
        while(i <= j) {
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            if(!Character.isLetterOrDigit(iChar)) {
                i++;
            } else if (!Character.isLetterOrDigit(jChar)) {
                j--;
            } else { 
                if (Character.toLowerCase(iChar) != Character.toLowerCase(jChar)) {
                return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}

// regex
// 33ms 14%
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}