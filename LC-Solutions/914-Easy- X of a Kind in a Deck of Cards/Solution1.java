/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 30, 2018
 Problem:    X of a Kind in a Deck of Cards
 Difficulty: Easy
 Notes:
In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
Example 2:

Input: [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.
Example 3:

Input: [1]
Output: false
Explanation: No possible partition.
Example 4:

Input: [1,1]
Output: true
Explanation: Possible partition [1,1]
Example 5:

Input: [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2]

Note:

1 <= deck.length <= 10000
0 <= deck[i] < 10000
 */

// this is wrong!!! 
// not pass case:
// [1,1,2,2,2,2] output: false, expected: true.
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length < 1) return false;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int card: deck) {
            if(!countMap.containsKey(card)) {
                countMap.put(card, 0);
            }
            countMap.put(card, countMap.get(card)+1);
        }
        int candidate = countMap.get(deck[0]);
        for(Integer group: countMap.keySet()) {
            if(countMap.get(group) != candidate) {
                return false;
            }
        }
        return candidate < 2? false: true;
    }
}


//
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length < 1) return false;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int card: deck) {
            if(!countMap.containsKey(card)) {
                countMap.put(card, 0);
            }
            countMap.put(card, countMap.get(card)+1);
        }
        int candidate = 2, minNum = Integer.MAX_VALUE;
        for(Integer groupVal: countMap.values()) {
            if(groupVal < minNum) {
                minNum = groupVal;
            }
        }
        boolean res = true;
        while(candidate <= minNum) {
            res = true;
            for(Integer groupVal: countMap.values()) {
                if(groupVal % candidate != 0) {
                    res = false;
                    break;
                }
            }
            if(res) break;
            else candidate++;
        }
        return minNum < 2? false: res;
    }
}