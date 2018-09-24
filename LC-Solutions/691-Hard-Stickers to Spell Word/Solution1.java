/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 19, 2018
 Problem:    Stickers to Spell Word
 Difficulty: Hard
 Notes:
We are given N different types of stickers. Each sticker has a lowercase English word on it.

You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.

You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.

Example 1:

Input:

["with", "example", "science"], "thehat"
Output:

3
Explanation:

We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.
Example 2:

Input:

["notice", "possible"], "basicbasic"
Output:

-1
Explanation:

We can't form the target "basicbasic" from cutting letters from the given stickers.
Note:

stickers has length in the range [1, 50].
stickers consists of lowercase English words (without apostrophes).
target has length in the range [1, 15], and consists of lowercase English letters.
In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was chosen as a concatenation of two random words.
The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 35ms on average.
*/

//TLE
class Solution {
    public int minStickers(String[] stickers, String target) {
        int[] need = new int[26];
        char[] tc = target.toCharArray();
        for(int i = 0; i < tc.length; i++) {
            need[tc[i]-'a']++;
        }
        List<int[]> collections = new ArrayList<>();
        int[] sum = new int[26];
        for(int i = 0; i < stickers.length; i++) {
            int[] collection = new int[26];
            String sticker = stickers[i];
            char[] sc = sticker.toCharArray();
            for(int j = 0; j < sc.length; j++) {
                collection[sc[j] - 'a']++;
                sum[sc[j] - 'a']++;
            }
            if(intersect(collection, need)) {
                collections.add(collection);
            }
        }
        
        for(int i = 0; i < 26; i++) {
            if(sum[i] == 0 && need[i] > 0) return -1;
        }
        int[] res = new int[2]; // 0 is minimun, 1 is current temp
        res[0] = Integer.MAX_VALUE;
        dfs(collections, need, res, target.length());
        
        return res[0];
    }
    
    public void dfs(List<int[]> collections, int[] cur, int[] res, int needNum) {
        if(needNum <= 0) {
            res[0] = Math.min(res[0], res[1]);
        } else {
            int[] curCopy = new int[26];
            System.arraycopy(cur, 0, curCopy, 0, 26);
            for(int i = 0; i < collections.size(); i++) {
                if(intersect(collections.get(i), curCopy)) {
                    System.arraycopy(curCopy, 0, cur, 0, 26);
                    int num = cut(collections.get(i),cur);
                    res[1]++;
                    dfs(collections, cur, res, needNum-num);
                    res[1]--;
                }
            }
        }
    }
    
    public boolean intersect (int[] collection, int[] cur) {
        for(int i = 0; i < 26; i++) {
            if(collection[i] > 0 && cur[i] > 0) {
                return true;
            }
        }
        return false;
    }
    
    public int cut(int[] collection, int[] cur) {
        int num = 0;
        for(int i = 0; i < 26; i++) {
            if(collection[i] > 0 && cur[i] > 0) {
                int temp = Math.min(collection[i], cur[i]);
                cur[i] -= temp;
                num += temp;
            }
        }
        return num;
    }
}
