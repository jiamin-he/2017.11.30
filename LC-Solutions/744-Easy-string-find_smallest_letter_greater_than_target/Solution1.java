/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 09, 2017
 Problem:    Find Smallest Letter Greater Than Target
 Difficulty: Easy
 Notes:
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
*/

// 注意可以环路回头比！！
// 14ms
// 注意他们已经sorted了！！ 这个方法 是 o n -- 有 log n 的方法！！
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int min = Integer.MAX_VALUE;
        char res = ' ';
        for(char c:letters){
            int temp = c-target > 0? c-target: c-target+26;
            if(temp < min) {
                min = temp;
                res = c;
            }
        }
        return res;
    }
}


// binary search
// O logn
// 10ms 
// 仔细思考 end 移到middle -1 ！！！！ start 移到 middle  + 1！！
// 就算end移错了 start也会移回来！ 所以最后才能用start去判断
// 而且如果不让end多移一个 最后会有可能无法退出循环！！
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length -1;
        while (start <= end) {
            int middle = start + (end-start)/2 ;
            if (letters[middle] > target) end = middle;
            else start = middle + 1;
        }
        return start == letters.length ? letters[0] : letters[start];
    }
}

// 当然也可以用treeset
// 虽然这种奇怪的数据结构会慢
// 23ms
class Solution {
      public char nextGreatestLetter(char[] letters, char target) {
        TreeSet<Character> treeSet = new TreeSet<>();
        for (char c : letters) {
            treeSet.add(c);
        }
        if (treeSet.higher(target) == null) {
            return treeSet.first();
        }
        return treeSet.higher(target);
    }
}

