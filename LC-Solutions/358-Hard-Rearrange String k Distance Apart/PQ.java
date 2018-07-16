/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 04, 2018
 Problem:    Rearrange String k Distance Apart
 Difficulty: Hard
 Notes:

Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
s = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
Example 2:
s = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.
Example 3:
s = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.
*/

// O(nlogn)
// 23ms 68%
class Solution {
    public String rearrangeString(String s, int k) {
        char[] sc = s.toCharArray();
        int[] candidate = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            public int compare (Character c1, Character c2) {
                return candidate[c2-'a'] - candidate[c1-'a'];    
            }
        });
        for(char c: sc){
            candidate[c-'a']++;
        }
        for(int i=0; i < 26; i++){
            if(candidate[i]> 0){
                pq.offer((char)('a'+i));
            }
        }
        Deque<Character> blockQ = new ArrayDeque<>();
        // construct the string
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Character can = pq.poll();
            blockQ.offer(can);
            sb.append(can);
            candidate[can-'a']--;
            if(blockQ.size()<k){
                continue;
            } else {
                char c = blockQ.poll();
				// this is important!! don't offer c to the queue without checking if it still needs to be added into the queue.
                if(candidate[c-'a'] > 0)
                    pq.offer(c);
            }
        }
        return sb.length() == s.length()? sb.toString():"";
        
    }
}