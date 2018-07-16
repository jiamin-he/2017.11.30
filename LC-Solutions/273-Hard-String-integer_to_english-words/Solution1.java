/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    Integer to English Words
 Difficulty: hard
 Notes:
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/


class Solution {
    public String numberToWords(int num) {
        String[] group = {"", "Thousand", "Million", "Billion", "Trillion"};   
        String s = "";
        int count = 0;
        if(num == 0) return "Zero";
        while(num > 0) {
            if(num % 1000 != 0) {
                s = convert(num%1000) + " " + group[count] + " " + s;  
            }
            num /= 1000;
            count++;
        }
        return s.trim();
    }
    
    public String convert(int num) {
        String[] twenties = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                            "Nineteen"};
        String[] hundred = {"","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        String s = "";
        if(num / 100 > 0) {
            s += twenties[num/100] + " Hundred ";
            num = num % 100;
        }
        if( num < 20) {
            s += twenties[num];
        } else {
            s += hundred[num/10] +" " + twenties[num%10];
        }
        return s.trim();
    }
}