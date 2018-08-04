/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 21st, 2018
 Problem:    String Compression
 Difficulty: Easy
 Notes:

Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
Example 2:
Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
Note:
All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.

*/


// 4ms 100%
// 我用了太多指针变换了！！！要把自己绕晕了！！
class Solution {
    public int update(char[] chars, int mod, int count, int i) {
        chars[mod++] = chars[i-1];
        if(count > 1) {
            int start = mod;
            while(count > 0) {
                chars[start++] = (char)(count%10 + '0');
                count /= 10;
            }
            int end = start-1;
            start = mod;
            mod = end+1;
            while( start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            } 
        }
        
        return mod;
    }
    public int compress(char[] chars) {
        if(chars.length < 2) return chars.length;
        int mod = 0, count = 1;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i-1]) {
                count++;
            } else {
                mod = update(chars, mod,count, i);
                count=1;
            }
        }
        return update(chars,mod,count, chars.length);
    }
}

// 利用api！！！！
class Solution {
    public int compress(char[] chars) {
        if(chars.length <= 1)return chars.length;
        int slow = 0, fast = 0;
        
        while(fast < chars.length){
            int count = 0;
            char firstDiff = chars[fast];
            while(fast < chars.length && firstDiff == chars[fast]){
                fast++;
                count++;
            }
            chars[slow++] = firstDiff;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[slow++] = c;
        }
        return slow;
    }
}