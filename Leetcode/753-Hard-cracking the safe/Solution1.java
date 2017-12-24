/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 23, 2017
 Problem:    Cracking the safe
 Difficulty: Hard
 Notes:
There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.

You can keep inputting the password, the password will automatically be matched against the last n digits entered.

For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.

Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.

Example 1:
Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.
Example 2:
Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.
Note:
n will be in the range [1, 4].
k will be in the range [1, 10].
k^n will be at most 4096.
*/

// 31ms
// coz intermediate process-->string --> slow
class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        // add the first one
        for(int i = 0; i < n; i++) sb.append('0');
        visited.add(sb.toString());
        int total = (int) (Math.pow(k,n)) -1;
        
        while(total-- > 0) {
            for(int i = k-1; i >= 0; i--) {
                StringBuilder cur = new StringBuilder();
                cur = new StringBuilder(sb.substring(sb.length()-n+1,sb.length()));
                cur.append(i);
                String temp = cur.toString();
                if(!visited.contains(temp)){
                    visited.add(temp);
                    sb.append(i);
                    break;
                }
            }
        }
        return sb.toString();
    }
}

// 26ms 
// use append to copy the last (n-1) digits
// string builder is faster than string
class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        // add the first one
        for(int i = 0; i < n; i++) sb.append('0');
        visited.add(sb.toString());
        int total = (int) (Math.pow(k,n)) -1;
        
        while(total-- > 0) {
            for(int i = k-1; i >= 0; i--) {
                StringBuilder cur = new StringBuilder();
                for(int pos = sb.length() -n+1; pos < sb.length(); pos++) {
                    cur.append(sb.charAt(pos));
                }
                cur.append(i);
                String temp = cur.toString();
                if(!visited.contains(temp)){
                    visited.add(temp);
                    sb.append(i);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
