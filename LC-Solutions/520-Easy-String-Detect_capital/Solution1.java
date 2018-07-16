/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 22, 2017
 Problem:    Detect Capital
 Difficulty: Medium
 Notes:

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
*/

import java.util.*;

class Solution1 {

    public boolean detectCapitalUse1(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }

    public boolean detectCapitalUse2(String word) {
        return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    }

    public boolean detectCapitalUse3(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

    public boolean detectCapitalUse4(String word) {
        int count = 0;
        for(char c : word.toCharArray()){
            if('Z' - c >= 0 ) count++;
        }
        return (count == 0 || count == word.length() || (count == 1 && 'Z' - word.charAt(0) >= 0));
    }

    public boolean detectCapitalUse5(String word) {
        if(word.length()<=1) return true;
        for(int i=1;i<word.length();i++){
            if(word.charAt(0)-'a'>= 0){
                if(word.charAt(i) - 'a' < 0 ) return false;
            } 
            else{
                if(word.charAt(1) - 'a' >= 0){
                    if(word.charAt(i) - 'a' < 0) return false;
                }
                else{
                    if(word.charAt(i) - 'a' >= 0) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
       
    }
}
