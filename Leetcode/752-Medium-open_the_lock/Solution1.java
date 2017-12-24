/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 23, 2017
 Problem:    Open the Lock
 Difficulty: Medium
 Notes:
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
Note:
The length of deadends will be in the range [1, 500].
target will not be in the list deadends.
Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
*/

// 45ms two-ended bfs
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dict = new HashSet<>(Arrays.asList(deadends));
        Set<String> begins = new HashSet<>();
        Set<String> ends = new HashSet<>();
        begins.add("0000");
        ends.add(target);
        int[] param = new int[]{1,-1};
        if(dict.contains("0000")) return -1;
        
        int len = 1; // it includes itself by given example
        while (begins.size() != 0 && ends.size() != 0) { //if ends is empty means we have found the endWord
            if (begins.size() > ends.size()) {
                Set<String> tmp = begins;
                begins = ends;
                ends = tmp;
            }

            Set<String> next = new HashSet<>();
            for (String w : begins) {
                char[] chars = w.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    for (int p: param) {
                        if(chars[i] == '0' && p == -1) {
                            chars[i] = '9';
                        } else if(chars[i] == '9' && p == 1) {
                            chars[i] = '0';
                        } else {
                            chars[i] = (char)(tmp + p);
                        }
                        String word = String.valueOf(chars);
                        if (ends.contains(word)) {
                            return len;
                        }
                        if (!dict.contains(word)) {
                            next.add(word);
                        }
                        chars[i] = tmp;
                    }
                    chars[i] = tmp;
                }
            }
            begins = next;
            len++;
        }
        
        return -1;
    }
}

// 加一个visited 的hashset 会快一点
// 45ms
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dict = new HashSet<>(Arrays.asList(deadends));
        Set<String> begins = new HashSet<>();
        Set<String> ends = new HashSet<>();
        Set<String> visited = new HashSet<>();
        begins.add("0000");
        ends.add(target);
        int[] param = new int[]{1,-1};
        if(dict.contains("0000")) return -1;
        
        int len = 1; // it includes itself by given example
        while (begins.size() != 0 && ends.size() != 0) { //if ends is empty means we have found the endWord
            if (begins.size() > ends.size()) {
                Set<String> tmp = begins;
                begins = ends;
                ends = tmp;
            }

            Set<String> next = new HashSet<>();
            for (String w : begins) {
                char[] chars = w.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    for (int p: param) {
                        if(chars[i] == '0' && p == -1) {
                            chars[i] = '9';
                        } else if(chars[i] == '9' && p == 1) {
                            chars[i] = '0';
                        } else {
                            chars[i] = (char)(tmp + p);
                        }
                        String word = String.valueOf(chars);
                        if (ends.contains(word)) {
                            return len;
                        }
                        if (!dict.contains(word) && !visited.contains(word)) {
                            next.add(word);
                            visited.add(word);
                        }
                        chars[i] = tmp;
                    }
                    chars[i] = tmp;
                }
            }
            begins = next;
            len++;
        }
        
        return -1;
    }
}

// memory limit exceeded.
class Solution {
    public int openLock(String[] deadends, String target) {
        int level = 0;
        Set<String> dict = new HashSet<>(Arrays.asList(deadends));
        int[] param = new int[]{1,-1};
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int size = q.size();
        while(!q.isEmpty()) {
            level++;
            while(size > 0) {
                String s = q.poll();
                size--;
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    for (int p: param) {
                        if(chars[i] == '0' && p == -1) {
                            chars[i] = '9';
                        } else if(chars[i] == '9' && p == 1) {
                            chars[i] = '0';
                        } else {
                            chars[i] = (char)(tmp + p);
                        }
                        String word = String.valueOf(chars);
                        if(!dict.contains(word)) {
                            if(word.equals(target)) {
                                return level;   
                            }
                            q.add(word);
                        }
                        chars[i] = tmp;
                    }
                    chars[i] = tmp;
                }
            }
            size = q.size();
        }
        return -1;
    }
}

// add a "visited" hashset
// 134ms 
// avoid memory exceeded
class Solution {
    public int openLock(String[] deadends, String target) {
        int level = 0;
        Set<String> dict = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        int[] param = new int[]{1,-1};
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int size = q.size();
        if(dict.contains("0000")) return -1;
        while(!q.isEmpty()) {
            level++;
            while(size > 0) {
                String s = q.poll();
                size--;
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char tmp = chars[i];
                    for (int p: param) {
                        if(chars[i] == '0' && p == -1) {
                            chars[i] = '9';
                        } else if(chars[i] == '9' && p == 1) {
                            chars[i] = '0';
                        } else {
                            chars[i] = (char)(tmp + p);
                        }
                        String word = String.valueOf(chars);
                        if(!dict.contains(word)) {
                            if(word.equals(target)) {
                                return level;   
                            }
                            if(!visited.contains(word)){
                                q.add(word);
                                visited.add(word);
                            }
                        }
                        chars[i] = tmp;
                    }
                    chars[i] = tmp;
                }
            }
            size = q.size();
        }
        return -1;
    }
}