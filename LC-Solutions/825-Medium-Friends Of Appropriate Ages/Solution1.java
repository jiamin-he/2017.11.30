/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 05, 2018
 Problem:    Friends Of Appropriate Ages
 Difficulty: Medium
 Notes:
Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output: 
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 

Notes:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.


*/

// 28ms 18%
class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0, len = ages.length, same = 1, countOnce = 0;
        for(int i = len-1; i >= 0;i--) {
            
            for(int j = i-1; j>= 0; j--) {
                if(ages[j] <= (0.5*ages[i]+7)) {
                    break;
                } else {
                    countOnce++;
                }
            }
            while(i> 0 && ages[i] == ages[i-1]){
                i--;
                same++;
            }
            count += (countOnce*same);
            countOnce = 0;
            same = 1;
        }
        return count;
    }
}

// 6ms 98%
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];
        int[] sumCount = new int[121];
        for(int age:ages) {
            ageCount[age]++;
        }
        int count = 0;
        for(int i = 15; i < 121; i++) {
            sumCount[i] = ageCount[i]+sumCount[i-1];
            int friends = sumCount[i] - sumCount[i/2+7];
            if(friends>1) count+=(friends-1)*ageCount[i];
        }
        return count;
    }
}