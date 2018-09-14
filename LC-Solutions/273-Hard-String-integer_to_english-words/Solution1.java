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


// Sep 8th 2018 review
// 5ms 13%
class Solution {
    public String numberToWords(int num) {
        String[] group = {"", "Thousand", "Million", "Billion", "Trillion"};   
        String res = "";
        int index = 0;
        if(num == 0) res = "Zero";
        while(num > 0){
            if (num%1000 != 0)
                res = helper(num%1000) +" " + group[index] + " " + res;
            num = num /1000;
            index++;
        }
        return res.trim();
    }
    
    public String helper(int num) {
        String[] twenties = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                            "Nineteen"};
        String[] hundred = {"","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"};
        String res;
        if(num >= 100) {
            res = twenties[num/100] + " " + hundred[10] +" " + helper(num%100);
        } else {
            if(num >= 20) {
                res = hundred[num/10] + " " + twenties[num%10];
            } else {
                res = twenties[num];
            }
        }
        return res.trim();
    }
}

// follow up
// floating number
If Number is floating even then it is easy

int roundedInt = Math.floar(number)
String s = aboveSol(roundedInt)
float = number - roundedInt // It Will give You float after and let assue we want to calculate after 3 decinmal point
tempRaisedFloat = (int)float*1000

now you have number which you wirte

s=s+ "."+ convertToStirng(tempRaisedFloat )
	
	//using stringbuilder will be better