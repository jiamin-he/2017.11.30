/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 21, 2017
 Problem:    Find the Closest Palindrome
 Difficulty: hard
 Notes:
Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.

*/

// 先转成int 然后逐个+1 或者 -1 来找到最近的那个？
// 不行啊 string 最长 18位 已经超出了int的最大范围了！
// 看报错信息：
// Line 3: java.lang.NumberFormatException: For input string: "807045053224792883"
// 就算都改成long类型也不行！
// 变成 tle 了！！！
// 一个一个加来比较太慢了！很费时间！
class Solution {
    public String nearestPalindromic(String n) {
        int num = Integer.parseInt(n);
        boolean plus = false, minus = false;
        int i = 1;
        for(; !plus && !minus; i++) {
            plus = isPalindrome(num+i);
            minus = isPalindrome(num-i);
        }
        if(minus) return Integer.toString(num-i+1);
        return Integer.toString(num+i-1);
    }
    
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}

// copy and paste
// 22ms 30%
public class Solution {
    public String nearestPalindromic(String n) {
        Long number = Long.parseLong(n);
        Long big = findHigherPalindrome(number + 1);
        Long small = findLowerPalindrome(number - 1);
        return Math.abs(number - small) > Math.abs(big - number) ? String.valueOf(big) : String.valueOf(small);
    }
    public Long findHigherPalindrome(Long limit) {
        String n = Long.toString(limit);
        char[] s = n.toCharArray(); // limit
        int m = s.length;
        char[] t = Arrays.copyOf(s, m); // target
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] < t[i]) {
                return Long.parseLong(String.valueOf(t)); 
            } else if (s[i] > t[i]) { 
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (++t[j] > '9') {
                        t[j] = '0';
                    } else {
                        break;
                    }
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t)); 
            }
        }
        return Long.parseLong(String.valueOf(t));    
    }
    public Long findLowerPalindrome(Long limit) {
        String n = Long.toString(limit);
        char[] s = n.toCharArray();
        int m = s.length;
        char[] t = Arrays.copyOf(s, m);
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] > t[i]) {
                return Long.parseLong(String.valueOf(t)); 
            } else if (s[i] < t[i]) {
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (--t[j] < '0') {
                        t[j] = '9';
                    } else {
                        break;
                    }
                }
                if (t[0] == '0') {
                    char[] a = new char[m - 1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a)); 
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t)); 
            }
        }
         return Long.parseLong(String.valueOf(t));  
    }
}


// 同样的思路
// 19ms
class Solution {
    public String nearestPalindromic(String n) {
        if(n.equals("0"))return "-1";
        Long num=Long.parseLong(n);
        boolean isNegative= n.charAt(0)=='-';
        Long max=findMax(Math.abs(num)+1);
        Long min=findMin(Math.abs(num)-1);
        Long res=Math.abs(max-num)<Math.abs(min-num)?max:min;
        return String.valueOf(res);
    }

    private static Long findMax(Long n){
        char[] chars=String.valueOf(n).toCharArray();
        char[] temp= Arrays.copyOf(chars,chars.length);
        int m=chars.length;
        for(int i=0;i<m/2;i++)temp[m-1-i]=temp[i];
        if(Long.parseLong(String.valueOf(temp))>=n)return Long.parseLong(String.valueOf(temp));
        for(int j=(m-1)/2;j>=0;j--) {
            if (++temp[j] > '9') temp[j] = '0';
            else break;
        }
        for(int i=0;i<m/2;i++)temp[m-1-i]=temp[i];

        return Long.parseLong(String.valueOf(temp));

    }
    private static Long findMin(Long n){
        char[] chars=String.valueOf(n).toCharArray();
        int m=chars.length;
        char[] temp=Arrays.copyOf(chars,m);
        for(int i=0;i<m/2;i++)temp[m-i-1]=chars[i];
        if(Long.parseLong(String.valueOf(temp))<=n)return Long.parseLong(String.valueOf(temp));
        for(int j=(m-1)/2;j>=0;j--){
            if(temp[j]=='0')temp[j]='9';
            else {temp[j]--;break;}
        }
        if(temp[0]=='0'){
            char[] t2=new char[m-1];
            Arrays.fill(t2,'9');
            return Long.parseLong(String.valueOf(t2));
        }
        for(int j=0;j<m/2;j++)temp[m-1-j]=temp[j];

        return Long.parseLong(String.valueOf(temp));

    }
}