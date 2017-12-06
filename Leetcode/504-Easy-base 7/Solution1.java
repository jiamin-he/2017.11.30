/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 25, 2017
 Problem:    base 7
 Difficulty: Easy
 Notes:
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].

*/

class Solution1 {
    public String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        if(num == 0) return "0";
        while(num > 0){
            int a = num % 7;
            res.insert(0,(char)(a+48));
            num = num / 7;
        }
        if(num < 0){
            res.append('-');
            res.append(convertToBase7(-num));
        } 
        
        return res.toString();
    }
}

class Solution2 {
    public String convertToBase7(int num) {
        return Integer.toString(num,7);
    }
}

class Solution3 {
    public String convertToBase7(int num) {
        
        if(num==0)
            return "0";
        String ans="";
        int temp=num;
        while(temp!=0){
            ans= Math.abs(temp%7)+ans;
            temp/=7;
        }
        return num<0 ? "-"+ans:ans;
        
    }
}

class Solution4 {
public String convertTo7(int num) {
    if (num < 0)
        return '-' + convertTo7(-num);
    if (num < 7)
        return num + "";
    return convertTo7(num / 7) + num % 7;
}
}