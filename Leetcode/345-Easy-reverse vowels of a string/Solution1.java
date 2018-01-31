/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 28, 2017
 Problem:    reverse vowels of a string
 Difficulty: Easy
 Notes:

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/

// 6ms 77% 
// 但是 while 中 while 有点乱
class Solution {
    public String reverseVowels(String s) {
        char[] sc = s.toCharArray();
        int left = 0, right = sc.length -1;
        while(left < right) {
            while(left < sc.length && !isVowel(sc[left])) left++;
            while(right >= 0 && !isVowel(sc[right])) right--;
            if((left > right) || left >= sc.length || right < 0) break;
            swap(left, right, sc);
            left++;
            right--;
        }
        return new String(sc);
    }
    private boolean isVowel(char c) {
        return c=='a'||c=='e' || c=='i' || c=='o' || c== 'u' ||c== 'A' ||c== 'E'||c== 'I'||c== 'O'||c== 'U';
    }
    private void swap(int l, int r, char[] sc) {
        char temp = sc[l];
        sc[l] =sc[r];
        sc[r] = temp;
    }
}

// 这个if 中if更加好一些
class Solution {
    public String reverseVowels(String s) {
        if (s==null||s.length()==0) return s;
        char[] c=s.toCharArray();
        int left=0, right=s.length()-1;
        while(left<right) {
            if (isValid(c, left)) {
                if (isValid(c, right)) {
                    char tmp=c[left];
                    c[left]=c[right];
                    c[right]=tmp;
                    left++;
                    right--;
                }else right--;
            }else left++;
        }
        return new String(c);
    }
    public boolean isValid(char[] c, int i){
        return c[i]=='o'||c[i]=='O'||c[i]=='e'||c[i]=='E'||c[i]=='i'||c[i]=='I'||c[i]=='a'||c[i]=='A'||c[i]=='u'||c[i]=='U';
    }
}