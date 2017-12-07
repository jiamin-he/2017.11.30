/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 5, 2017
 Problem:    Integer to roman 
 Difficulty: Medium
 Notes:
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

// 112ms 32.41%
class Solution {
    public String intToRoman(int num) {
        String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] C= {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] M= {"", "M", "MM", "MMM"};
        StringBuilder sb = new StringBuilder();
        sb.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[(num%10)]);
        return sb.toString();
    }
}

// 用string builder也不总是快的！
// 这个100ms 50%
	String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];