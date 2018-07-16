/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 5, 2017
 Problem:    Roman to integer
 Difficulty: Easy
 Notes:
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

// 从最高位开始扫
// count every Symbol and add its value to the sum, and minus the extra part of special cases.
// 133ms 15.57%
public int romanToInt(String s) {
    int sum=0;
    if(s.indexOf("IV")!=-1){sum-=2;}
    if(s.indexOf("IX")!=-1){sum-=2;}
    if(s.indexOf("XL")!=-1){sum-=20;}
    if(s.indexOf("XC")!=-1){sum-=20;}
    if(s.indexOf("CD")!=-1){sum-=200;}
    if(s.indexOf("CM")!=-1){sum-=200;}
    
    char c[]=s.toCharArray();
    
   	for(int count = 0; count < s.length(); count++){
       if(c[count]=='M') sum+=1000;
       if(c[count]=='D') sum+=500;
       if(c[count]=='C') sum+=100;
       if(c[count]=='L') sum+=50;
       if(c[count]=='X') sum+=10;
       if(c[count]=='V') sum+=5;
       if(c[count]=='I') sum+=1;  
   	}
   
   return sum;   
}