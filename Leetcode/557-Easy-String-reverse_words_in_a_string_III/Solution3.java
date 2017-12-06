/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 02, 2017
 Problem:    reverse words in a string iii
 Difficulty: Easy
 Notes:

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

 */

// 自己写reverse 自己来split
// 借助系统函数直接找到空格 比solution2 自己一个个找空格又优化一点
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int index = s.indexOf(' ', i);
            if (index == -1) {
                reverse(chars, i, chars.length - 1);
                break;
            }
            reverse(chars, i, index - 1);
            i = index + 1;
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}