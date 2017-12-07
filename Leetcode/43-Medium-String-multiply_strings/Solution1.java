/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 06, 2017
 Problem:    Multiply Strings
 Difficulty: Medium
 Notes:
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

// 第 1 3 个版本是我写的 纵观三个版本的差别 发现
// 对string 进行 charAt 比 先改成array 再直接对array进行访问 要慢很多！！！
// and 放在前面先处理奇奇怪怪的length==0 也可以st速度快一点点
// 30 ms 39%
class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                temp += res[i+j+1];
                res[i+j] = res[i+j] + temp/10;
                res[i+j+1] = temp%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: res) {
            if(sb.length() != 0 || i != 0) {
                sb.append(i);
            }
        }
        if(sb == null || sb.length() == 0) return "0";
        return sb.toString();
    }
}

//28ms 59%
class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int m = num1.length(), n = num2.length();
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int[] res = new int[m + n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int p1 = i + j + 1; //result
                int p2 = i + j; //carry's index
                int mul = (arr1[i] - '0') * (arr2[j] - '0');
                int result = mul + res[p1];
                res[p1] = result % 10;
                res[p2] += result / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: res) {
            if(i == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(i);
        }
        return (sb.length() == 0 ? "0": sb.toString());
    }
}

// 23ms 99%
class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int[] res = new int[num1.length() + num2.length()];
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        for(int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = (arr1[i]-'0') * (arr2[j]-'0');
                temp += res[i+j+1];
                res[i+j] = res[i+j] + temp/10;
                res[i+j+1] = temp%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i: res) {
            if(sb.length() != 0 || i != 0) {
                sb.append(i);
            }
        }
        if(sb == null || sb.length() == 0) return "0";
        return sb.toString();
    }
}