/*
Author: Jiamin
Date: Jan 05, 2017
Problem: Encode String with Shortest Length
Difficulty: hard
Given a non-empty string, encode the string such that its encoded length is the shortest.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.

Note:
k will be a positive integer and encoded string will not be empty or have extra space.
You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.
Example 1:

Input: "aaa"
Output: "aaa"
Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.
Example 2:

Input: "aaaaa"
Output: "5[a]"
Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
Example 3:

Input: "aaaaaaaaaa"
Output: "10[a]"
Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".
Example 4:

Input: "aabcaabcd"
Output: "2[aabc]d"
Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
Example 5:

Input: "abbbabbbcabbbabbbc"
Output: "2[2[abbb]c]"
Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".
*/

//323ms 43%
// O(n^4)
class Solution {
    public String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];
        for(int i = len -1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                String subStr = s.substring(i,j+1);
                if(j-i < 4) {
                    dp[i][j] = subStr;
                } else {
                    dp[i][j] = subStr;
                    for(int k = i; k < j; k++) {
                        // dp[i][k].length() + dp[k+1][j].length()
                        // is much faster than (dp[i][k] + dp[k+1][j]).length()
                        // because s1 + s2 is O(n) time, s1.length() + s2.length() is O(1) time
                        if(dp[i][k].length() + dp[k+1][j].length() < dp[i][j].length()) dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                    for(int k = 0; k < subStr.length(); k++) {
                        String repeatStr = subStr.substring(0,k+1);
                        if(repeatStr != null && subStr.length()%repeatStr.length() == 0 && subStr.replaceAll(repeatStr,"").length() == 0) {
                            String str = subStr.length() / repeatStr.length() + "[" + dp[i][i+k] + "]";
                            if(str.length() < dp[i][j].length()) {
                                dp[i][j] = str;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}


// 47ms 83%
// 其实只是把判断能否合起来的第二个for循环修改了一下
// 就会快了很多
// 因为上面那个要逐个比较 最后需要 O(n^2 * (n+n))
// 现在这里比较的时候一步到位，需要 O(n^2 * n) 
class Solution {
    public String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];
        for(int i = len -1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                String subStr = s.substring(i,j+1);
                if(j-i < 4) {
                    dp[i][j] = subStr;
                } else {
                    dp[i][j] = subStr;
                    for(int k = i; k < j; k++) {
                        if(dp[i][k].length() + dp[k+1][j].length() < dp[i][j].length()) dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                    // 修改了这个地方
                    String twoSub = subStr+subStr;
                    int subLen = j-i+1;
                    int pos = twoSub.indexOf(subStr, 1);
                    String encode = "";
                    if(pos != -1 && pos < subLen) {
                        encode = subLen/pos + "[" + dp[i][i+pos-1] + "]";
                        if(encode.length() < dp[i][j].length()) {
                            dp[i][j] = encode;
                        }
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}