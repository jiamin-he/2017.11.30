/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    Add Binary
 Difficulty: Easy
 Notes:
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

*/

// 这个不行的啊 有范围的 只能到2的31-1为止
// 官方示范样例
// parseInt("-2147483648", 10) returns -2147483648
//  parseInt("2147483648", 10) throws a NumberFormatException
//  parseInt("99", 8) throws a NumberFormatException
class Solution {
    public String addBinary(String a, String b) {
        int sum = 0;
        sum = Integer.parseInt(a,2) + Integer.parseInt(b,2);
        return Integer.toString(sum,2);
    }
}

// work！
// 5ms 25%
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = a.length() -1, j = b.length() -1; i >= 0 || j>= 0 ; i--,j--) {
            int sum = carry;
            if(i>=0) {
                sum += a.charAt(i)-'0';
            }
            if(j>=0) {
                sum += b.charAt(j)-'0';
            }
            sb.insert(0,sum % 2);
            carry = sum / 2;
        }
        if(carry > 0) sb.insert(0,carry);
        return sb.toString();
    }
}

// 在更长的那个数组上修改 属于in place！
// 从char[] 转成 string 很快的！
// 2ms 97%
class Solution {
    public String addBinary(String a, String b) {
        if(a.length() > b.length()) {
            return addHelper(a.toCharArray(), b.toCharArray());
        }
        return addHelper(b.toCharArray(), a.toCharArray());
    }
    
    public String addHelper(char[] a, char[] b) {
        int carry = 0;
        for(int i = a.length -1, j = b.length -1; i >= 0; i--,j--) {
            int sum = carry;
            if(i >= 0) {
                sum += a[i] - '0';
            }
            if(j >= 0) {
                sum += b[j] - '0';
            }
            carry = sum / 2;
            a[i] = (char)(sum%2 + '0');
        }
        if(carry == 0) return new String(a);
        else return "1"+new String(a);
    }
}